import { Component, NO_ERRORS_SCHEMA, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { Router, RouterModule } from '@angular/router';
import { TokenService } from '../../service/token.service';
import { UserService } from '../../service/user.service';
import { UserResponse } from '../../response/user/user.response';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../service/product.service';



@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule,CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent implements OnInit{
  userResponse?:UserResponse | null;
  isPopoverOpen = false;
  activeNavItem: number = 0;
  constructor(private dialogRef: MatDialog,
    private userService: UserService,       
    private tokenService: TokenService,
    private productService : ProductService,    
    private router: Router,
  ){}
  ngOnInit() {
    debugger
    this.userResponse = this.userService.getUserResponseFromLocalStorage();    
  }  

  dangxuat(): void {
      this.userService.removeUserFromLocalStorage();
      this.tokenService.removeToken();
      debugger
      this.productService.removeProductFromLocalStorage();
      debugger
      this.userResponse = this.userService.getUserResponseFromLocalStorage();    
    }
  setActiveNavItem(index: number) {   
    debugger 
    this.activeNavItem = index;
    //console.error(this.activeNavItem);
  }  
}
