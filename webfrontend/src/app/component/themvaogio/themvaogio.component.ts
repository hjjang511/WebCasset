import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { HeaderMixtapeComponent } from '../header-mixtape/header-mixtape.component';
import { HeaderComponent } from '../header/header.component';
import { Product } from '../../model/product';
import { CartService } from '../../service/cart.service';
import { ProductService } from '../../service/product.service';
import { ApiResponse } from '../../response/api.response';
import { environment } from '../../../environments/environment';
import { MauBangService } from '../../service/maubang.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-themvaogio',
  standalone: true,
  imports: [HeaderComponent,FooterComponent,HeaderMixtapeComponent, RouterModule,CommonModule, FormsModule],
  templateUrl: './themvaogio.component.html',
  styleUrl: './themvaogio.component.css'
})
export class ThemvaogioComponent implements OnInit {
  product?: Product;
  productId: number = 0;
  quantity: number = 1;
  bia:string='';
  isPressedAddToCart:boolean = false;
  constructor(
    private productService: ProductService,
    private maubangService: MauBangService,
    private cartService: CartService,
    // private categoryService: CategoryService,
    // private router: Router,
      private activatedRoute: ActivatedRoute,
      private router: Router,
    ) {
      
    }
    ngOnInit() {
      // Lấy productId từ URL      
      const idParam = this.activatedRoute.snapshot.paramMap.get('id');
      debugger
      if (idParam !== null) {
        this.productId = +idParam;
      }
      if (!isNaN(this.productId)) {
        this.productService.getProductsById(this.productId).subscribe({
          next: (apiResponse: ApiResponse) => {            
            // Lấy danh sách ảnh sản phẩm và thay đổi URL
            const response = apiResponse.data
            debugger
            this.bia= `${environment.apiBaseUrl}/products/images/${response.bia}`;            
            debugger
            this.product = response 
          },
          error: (error: HttpErrorResponse) => {
            console.error('Error fetching product:', error.message);
          }
        });    
      } else {
        console.error('Invalid productId:', idParam);
      }      
    }
    addToCart(): void {
      debugger
      this.isPressedAddToCart = true;
      if (this.product) {
        this.cartService.addToCart(this.product.id, this.quantity);
        this.router.navigate(['/trangchu']);
      } else {
        // Xử lý khi product là null
        console.error('Không thể thêm sản phẩm vào giỏ hàng vì product là null.');
      }
    }      
    buyNow(): void {      
      if(this.isPressedAddToCart == false) {
        this.addToCart();
      }
      this.router.navigate(['/hoadon']);
    } 
}
