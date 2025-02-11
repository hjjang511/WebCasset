import { Component, Inject, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';

import { Location } from '@angular/common';
import { environment } from '../../../../environments/environment';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { MauBang } from '../../../model/maubang';
import { MauBangService } from '../../../service/maubang.service';
import { ApiResponse } from '../../../response/api.response';


@Component({
  selector: 'app-product-admin',
  templateUrl: './product.admin.component.html',
  styleUrls: [
    './product.admin.component.scss',        
  ],
  standalone: true,
  imports: [   
    CommonModule,
    FormsModule,
  ]
})
export class ProductAdminComponent implements OnInit {
    selectedCategoryId: number  = 0; // Giá trị category được chọn
    products: MauBang[] = [];        
    currentPage: number = 0;
    itemsPerPage: number = 12;
    pages: number[] = [];
    totalPages:number = 0;
    visiblePages: number[] = [];
    keyword:string = "";
    localStorage?:Storage;

    private productService = inject(MauBangService);
    private router = inject(Router);
    private location = inject(Location);

    constructor(
      @Inject(DOCUMENT) private document: Document
    ) {
      this.localStorage = document.defaultView?.localStorage;
    }
    ngOnInit() {
      this.currentPage = Number(this.localStorage?.getItem('currentProductAdminPage')) || 0; 
      this.getProducts(this.keyword, 
        this.currentPage, this.itemsPerPage);      
    }    
    searchProducts() {
      this.currentPage = 0;
      this.itemsPerPage = 12;
      //Mediocre Iron Wallet
      debugger
      this.getProducts(this.keyword.trim(), this.currentPage, this.itemsPerPage);
    }
    getProducts(keyword: string, page: number, limit: number) {
      debugger
      this.productService.getProducts(keyword, page, limit).subscribe({
        next: (apiResponse: ApiResponse) => {
          debugger;
          const responseData = apiResponse?.data;
          if (responseData && Array.isArray(responseData.products)) {
            const products = responseData.products as MauBang[];
            products.forEach((product: MauBang) => {
              if (product) {
                product.url = `${environment.apiBaseUrl}/maubangs/images/${product.thumbnail}`;
              }
            });
            this.products = products;
            this.totalPages = responseData.totalPages;
            this.visiblePages = this.generateVisiblePageArray(this.currentPage, this.totalPages);
          } else {
            console.error('apiResponse.data.products is not an array:', responseData?.products);
            // Xử lý lỗi hoặc điều chỉnh mã của bạn nếu cần thiết
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
    onPageChange(page: number) {
      debugger;
      this.currentPage = page < 0 ? 0 : page;
      this.localStorage?.setItem('currentProductAdminPage', String(this.currentPage));     
      this.getProducts(this.keyword,this.currentPage, this.itemsPerPage);
    }
  
    generateVisiblePageArray(currentPage: number, totalPages: number): number[] {
      const maxVisiblePages = 5;
      const halfVisiblePages = Math.floor(maxVisiblePages / 2);
    
      let startPage = Math.max(currentPage - halfVisiblePages, 1);
      let endPage = Math.min(startPage + maxVisiblePages - 1, totalPages);
    
      if (endPage - startPage + 1 < maxVisiblePages) {
        startPage = Math.max(endPage - maxVisiblePages + 1, 1);
      }
    
      const visiblePages: number[] = [];
      for (let i = startPage; i <= endPage; i++) {
        visiblePages.push(i);
      }
    
      return visiblePages;
    }
    
    
    // Hàm xử lý sự kiện khi thêm mới sản phẩm
    insertProduct() {
      debugger
      // Điều hướng đến trang detail-product với productId là tham số
      this.router.navigate(['/admin/products/insert']);
    } 

    // Hàm xử lý sự kiện khi sản phẩm được bấm vào
    updateProduct(productId: number) {
      debugger
      // Điều hướng đến trang detail-product với productId là tham số
      this.router.navigate(['/admin/products/update', productId]);
    }  
    deleteProduct(product: MauBang) {      
      const confirmation = window
      .confirm('Are you sure you want to delete this product?');
      if (confirmation) {
        debugger
        this.productService.deleteProductImage(product.id).subscribe({
          next: (apiResponse: ApiResponse) => {         
          },
          complete: () => {
            debugger;          
          },
          error: (error: HttpErrorResponse) => {
            debugger;
            console.error(error?.error?.message ?? '');
          }
        }); 
        debugger
        this.productService.deleteProduct(product.id).subscribe({
          next: (apiResponse: ApiResponse) => {
            debugger 
            console.error('Xóa thành công')
            location.reload();          
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
    }      
}