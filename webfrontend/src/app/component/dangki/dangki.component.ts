import { HttpErrorResponse } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { RegisterDTO } from '../../dtos/user/register.dto';
import { ApiResponse } from '../../response/api.response';
import { UserService } from '../../service/user.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-dangki',
  standalone: true,
  imports: [FormsModule,RouterModule],
  templateUrl: './dangki.component.html',
  styleUrl: './dangki.component.css'
})
export class DangkiComponent {
  @ViewChild('registerForm') registerForm!: NgForm;
  // Khai báo các biến tương ứng với các trường dữ liệu trong form
  phoneNumber: string;
  password: string;
  retypePassword: string;
  fullName: string;
  address:string;
  isAccepted: boolean;
  dateOfBirth: Date;

  constructor(private router: Router, private userService: UserService,private dialogRef: MatDialog){
    debugger
    this.phoneNumber = '';
    this.password = '';
    this.retypePassword = '';
    this.fullName = '';
    this.address = '';
    this.isAccepted = true;
    this.dateOfBirth = new Date();
    this.dateOfBirth.setFullYear(this.dateOfBirth.getFullYear() - 18);
    //inject

  }
  onPhoneNumberChange(){
    console.log(`Phone typed: ${this.phoneNumber}`)
    //how to validate ? phone must be at least 6 characters
  }
  register() {
    const message = `phone: ${this.phoneNumber}`+
                    `password: ${this.password}`+
                    `retypePassword: ${this.retypePassword}`+
                    `address: ${this.address}`+
                    `fullName: ${this.fullName}`+
                    `isAccepted: ${this.isAccepted}`+
                    `dateOfBirth: ${this.dateOfBirth}`;
    //console.error(message);
    debugger
    
    const registerDTO:RegisterDTO = {
        "fullname": this.fullName,
        "phone_number": this.phoneNumber,
        "address": this.address,
        "password": this.password,
        "retype_password": this.retypePassword,
        "date_of_birth": this.dateOfBirth,
        "role_id": 2
    }
    this.userService.register(registerDTO).subscribe({
        next: (apiResponse: ApiResponse) => {
          debugger
          const confirmation = window
            .confirm('Đăng ký thành công, mời bạn đăng nhập. Bấm "OK" để chuyển đến trang đăng nhập.');
          if (confirmation) {
            this.router.navigate(['/']);
          }
        },
        complete: () => {
          debugger
        },
        error: (error: HttpErrorResponse) => {
          debugger;
          console.error(error?.error?.message ?? '');
        } 
    })   
  }

  //how to check password match ?
  checkPasswordsMatch() {    
    if (this.password !== this.retypePassword) {
      this.registerForm.form.controls['retypePassword']
            .setErrors({ 'passwordMismatch': true });
    } else {
      this.registerForm.form.controls['retypePassword'].setErrors(null);
    }
  }
  checkAge() {
    if (this.dateOfBirth) {
      const today = new Date();
      const birthDate = new Date(this.dateOfBirth);
      let age = today.getFullYear() - birthDate.getFullYear();
      const monthDiff = today.getMonth() - birthDate.getMonth();
      if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
        age--;
      }

      if (age < 18) {
        this.registerForm.form.controls['dateOfBirth'].setErrors({ 'invalidAge': true });
      } else {
        this.registerForm.form.controls['dateOfBirth'].setErrors(null);
      }
    }
  }
  closeAll(){
    this.dialogRef.closeAll();
  }
}
