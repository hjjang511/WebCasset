import { AdminComponent } from "./admin.component";
import { OrderAdminComponent } from "./order/order.admin.component";
import { DetailOrderAdminComponent } from "./detail-order/detail.order.admin.component";
import { RouterModule, Routes } from "@angular/router";
import { ProductAdminComponent } from "./product/product.admin.component";
import { UpdateProductAdminComponent } from "./product/update/update.product.admin.component";
import { InsertProductAdminComponent } from "./product/insert/insert.product.admin.component";
import { UserAdminComponent } from "./user/user.admin.component";
import { NgModule } from "@angular/core";
import { routes } from "../../app.routes";

export const adminRoutes: Routes = [
    {
        path: 'admin',
        component: AdminComponent,
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
    }
];
@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [RouterModule]
})
export class AdminRoutingModule { }

