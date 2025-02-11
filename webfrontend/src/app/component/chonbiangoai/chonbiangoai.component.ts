import { Component, Inject, OnInit } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import { HeaderMixtapeComponent } from '../header-mixtape/header-mixtape.component';
import {  Router, RouterModule } from '@angular/router';
import { ApiResponse } from '../../response/api.response';
import { MauBang } from '../../model/maubang';
import { DOCUMENT } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { environment } from '../../../environments/environment';
import { MauBangService } from '../../service/maubang.service';
import { ProductService } from '../../service/product.service';


@Component({
  selector: 'app-chonbiangoai',
  standalone: true,
  imports: [HeaderComponent,FooterComponent,HeaderMixtapeComponent,RouterModule,FormsModule],
  templateUrl: './chonbiangoai.component.html',
  styleUrl: './chonbiangoai.component.css'
})
export class ChonbiangoaiComponent implements OnInit{
  name:string='';
  selectedOption: number = 1;
  products: MauBang[] = [];
  selectedMB:number=0;
  currentPage: number = 0;
  itemsPerPage: number = 12;
  pages: number[] = [];
  totalPages:number = 0;
  visiblePages: number[] = [];
  keyword:string = "";

  constructor(
    private maubangService: MauBangService,
    private productService: ProductService, 
    private router: Router,
    ) {
    }
    ngOnInit() {
      this.getProducts(this.keyword, this.currentPage, this.itemsPerPage);
      this.productService.saveIdOtpNametoLocal(this.selectedMB,this.selectedOption,this.name)
    }
    getProducts(keyword: string, page: number, limit: number) {
      debugger;
      this.maubangService.getProducts(keyword, page, limit).subscribe({
        next: (apiresponse: ApiResponse) => {
          debugger;
          const response = apiresponse.data;
          response.products.forEach((product: MauBang) => {          
            product.url = `${environment.apiBaseUrl}/maubangs/images/${product.thumbnail}`;
          });
          this.products = response.products;
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

    save(id:number,otp:number,name:string){
      this.productService.saveIdOtpNametoLocal(id,otp,name);
      this.router.navigate(['/themnhac2'])
    }

    selectMB(productId:number){
      this.selectedMB = productId;
    }
    isSelectedOption(option: number): boolean {
      return this.selectedOption === option;
    }
}
