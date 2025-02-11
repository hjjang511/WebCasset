import { Component, Inject, OnInit } from '@angular/core';

import { Router, RouterModule } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { HeaderMixtapeComponent } from '../header-mixtape/header-mixtape.component';
import { HeaderComponent } from '../header/header.component';
import { CommonModule, DOCUMENT } from '@angular/common';
import { InsertCassetteDTO } from '../../dtos/cassette/insert.cassette.dto';
import { FormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { ProductService } from '../../service/product.service';
import { ApiResponse } from '../../response/api.response';

@Component({
  selector: 'app-themnhac2',
  standalone: true,
  imports: [HeaderComponent,FooterComponent,HeaderMixtapeComponent,RouterModule,CommonModule,FormsModule],
  templateUrl: './themnhac2.component.html',
  styleUrl: './themnhac2.component.css'
})
export class Themnhac2Component implements OnInit {
  matA:string=''
  matB:string=''
  insertCassetteDTO:InsertCassetteDTO= {
    name:'',
    matA:'',
    matB:'',
    otpName:0,
    maubangid:0,
  }
  constructor(
    private productservice: ProductService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
    ) {
    }
    ngOnInit(): void {
      this.insertCassetteDTO.name=this.productservice.setNamefromLocal();
      this.insertCassetteDTO.maubangid=this.productservice.setIdfromLocal();
      this.insertCassetteDTO.otpName=this.productservice.setOtpfromLocal();
      this.insertCassetteDTO.matA=this.matA;
      this.insertCassetteDTO.matB=this.matB;
    }

    insertProduct() {    
      this.productservice.insertProduct(this.insertCassetteDTO).subscribe({
        next: (apiResponse: ApiResponse) => {
          debugger;
          this.router.navigate(['/themvaogio',apiResponse.data.id]);
        },
        error: (error: HttpErrorResponse) => {
          debugger;
          console.error(error?.error?.message ?? '');
        } 
      });    
    }
}
