import { Routes } from '@angular/router';

import { ChonbiangoaiComponent } from './component/chonbiangoai/chonbiangoai.component';
import { Themnhac1Component } from './component/themnhac1/themnhac1.component';
import { Themnhac2Component } from './component/themnhac2/themnhac2.component';
import { ThemvaogioComponent } from './component/themvaogio/themvaogio.component';
import { TrangchuComponent } from './component/trangchu/trangchu.component';
import { HoadonComponent } from './component/hoadon/hoadon.component';
import { AuthGuardFn } from './guards/auth.guard';
import { UserProfileComponent } from './component/user-profile/user-profile.component';
import { LoginComponent } from './component/login/login.component';
import { DangkiComponent } from './component/dangki/dangki.component';
import { AdminComponent } from './component/admin/admin.component';
import { AdminGuardFn } from './guards/admin.guard';
import { DetailOrderAdminComponent } from './component/admin/detail-order/detail.order.admin.component';
import { OrderAdminComponent } from './component/admin/order/order.admin.component';
import { InsertProductAdminComponent } from './component/admin/product/insert/insert.product.admin.component';
import { ProductAdminComponent } from './component/admin/product/product.admin.component';
import { UpdateProductAdminComponent } from './component/admin/product/update/update.product.admin.component';
import { UserAdminComponent } from './component/admin/user/user.admin.component';

export const routes: Routes = [
    {path:'trangchu',component:TrangchuComponent},
    {path:'login',component:LoginComponent},   
    {path:'register',component:DangkiComponent},
    {path:'', redirectTo:"/trangchu", pathMatch:"full"},
    {path:'chonbiangoai', component:ChonbiangoaiComponent},
    {path:'themvaogio/:id', component:ThemvaogioComponent},
    {path:'themnhac2', component:Themnhac2Component},
    {path:'hoadon', component:HoadonComponent, canActivate:[AuthGuardFn]},
    {path:'themnhac1', component:Themnhac1Component},
    {path: 'user-profile', component: UserProfileComponent, canActivate:[AuthGuardFn] },
      //Admin   
  { 
    path: 'admin', 
    component: AdminComponent, 
    canActivate:[AdminGuardFn], 
    children: [
        {
            path: 'orders',
            component: OrderAdminComponent
        },            
        {
            path: 'products',
            component: ProductAdminComponent
        },
        //sub path
        {
            path: 'orders/:id',
            component: DetailOrderAdminComponent
        },
        {
            path: 'products/update/:id',
            component: UpdateProductAdminComponent
        },
        {
            path: 'products/insert',
            component: InsertProductAdminComponent
        },
        {
            path: 'users',
            component: UserAdminComponent
        },  
    ]
  },      
];

