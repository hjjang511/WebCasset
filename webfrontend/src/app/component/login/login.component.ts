import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DangkiComponent } from '../dangki/dangki.component';
import { FormsModule, NgForm } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule, Routes } from '@angular/router';
import { UserResponse } from '../../response/user/user.response';
import { Role } from '../../model/role';
import { CartService } from '../../service/cart.service';
import { RoleService } from '../../service/role.service';
import { TokenService } from '../../service/token.service';
import { UserService } from '../../service/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ApiResponse } from '../../response/api.response';
import { LoginDTO } from '../../dtos/user/login.dto';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,CommonModule,HeaderComponent,FooterComponent,RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  @ViewChild('loginForm') loginForm!: NgForm;
  phoneNumber: string = '';
  password: string = '';
  showPassword: boolean = false;

  roles: Role[] = []; // Mảng roles
  rememberMe: boolean = true;
  selectedRole: Role | undefined; // Biến để lưu giá trị được chọn từ dropdown
  userResponse?: UserResponse

  onPhoneNumberChange() {
    console.log(`Phone typed: ${this.phoneNumber}`);
    //how to validate ? phone must be at least 6 characters
  }
  constructor(private dialogRef: MatDialog, private router: Router,    
    private activatedRoute: ActivatedRoute,
    private userService: UserService,
    private tokenService: TokenService,
    private roleService: RoleService,
    private cartService: CartService){}
  ngOnInit(): void {
    // Gọi API lấy danh sách roles và lưu vào biến roles
    debugger
    this.roleService.getRoles().subscribe({      
      next: (apiResponse: ApiResponse) => { // Sử dụng kiểu Role[]
        debugger
        const roles = apiResponse.data
        this.roles = roles;
        this.selectedRole = roles.length > 0 ? roles[0] : undefined;
      },
      complete: () => {
        debugger
      },  
      error: (error: HttpErrorResponse) => {
        debugger;
        console.error(error?.error?.message ?? '');
      } 
    });
  }

  login() {
    const message = `phone: ${this.phoneNumber}` +
      `password: ${this.password}`;
    //console.error(message);
    debugger

    const loginDTO: LoginDTO = {
      phone_number: this.phoneNumber,
      password: this.password,
      role_id: this.selectedRole?.id ?? 1
    };
    this.userService.login(loginDTO).subscribe({
      next: (apiResponse: ApiResponse) => {
        debugger;
        const { token } = apiResponse.data;
        if (this.rememberMe) {          
          this.tokenService.setToken(token);
          debugger;
          this.userService.getUserDetail(token).subscribe({
            next: (apiResponse2: ApiResponse) => {
              debugger
              this.userResponse = {
                ...apiResponse2.data,
                date_of_birth: new Date(apiResponse2.data.date_of_birth),
              };    
              this.userService.saveUserResponseToLocalStorage(this.userResponse); 
              if(this.userResponse?.role.name == 'admin') {
                this.router.navigate(['/admin']);    
              } else if(this.userResponse?.role.name == 'user') {
                this.router.navigate(['/trangchu']);                      
              }
            },
            complete: () => {
              this.cartService.refreshCart();
              debugger;
            },
            error: (error: HttpErrorResponse) => {
              debugger;
              console.error(error?.error?.message ?? '');
            } 
          })
        }                        
      },
      complete: () => {
        debugger;
      },
      error: (error: HttpErrorResponse) => {
        debugger;
        console.error(error?.error?.message ?? '');
      } 
    });
  }
  togglePassword() {
    this.showPassword = !this.showPassword;
  }
  createAccount() {
    debugger
    // Chuyển hướng người dùng đến trang đăng ký (hoặc trang tạo tài khoản)
    this.router.navigate(['/register']); 
  }
}
