import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import {RouterModule} from "@angular/router";
import { AdminRoutingModule, adminRoutes } from './admin-routes';
import { CommonModule } from '@angular/common';
import { inject } from '@angular/core';
import { UserResponse } from '../../response/user/user.response';
import { TokenService } from '../../service/token.service';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: [
    './admin.component.scss',        
  ],  
  standalone: true,
  imports: [       
    CommonModule,    
    RouterModule,
  ],
  
  
})
export class AdminComponent implements OnInit {
  //adminComponent: string = 'orders';
  userResponse?:UserResponse | null;
  private userService = inject(UserService);
  private tokenService = inject(TokenService);
  private router = inject(Router);
    
  ngOnInit() {
    this.userResponse = this.userService.getUserResponseFromLocalStorage();    
    // Default router
    debugger
    if (this.router.url === '/admin') {
      this.router.navigate(['/admin/orders']);
    }
   }  
  logout() {
    this.userService.removeUserFromLocalStorage();
    this.tokenService.removeToken();
    this.userResponse = this.userService.getUserResponseFromLocalStorage();    
    this.router.navigate(['/']);
  }
  showAdminComponent(componentName: string): void {
    debugger
    if (componentName === 'orders') {
      this.router.navigate(['/admin/orders']);
    } else if (componentName === 'products') {
      this.router.navigate(['/admin/products']);
    } else if (componentName === 'users') {
      this.router.navigate(['/admin/users']);
    }
  }
}


/**
 npm install --save font-awesome
 angular.json:
 "styles": [   
    "node_modules/font-awesome/css/font-awesome.min.css"
],
 */