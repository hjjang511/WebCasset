import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OnInit } from '@angular/core';
import { InsertProductDTO } from '../../../../dtos/product/insert.product.dto';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { MauBangService } from '../../../../service/maubang.service';
import { ApiResponse } from '../../../../response/api.response';

@Component({
  selector: 'app-insert.product.admin',
  templateUrl: './insert.product.admin.component.html',
  styleUrls: ['./insert.product.admin.component.scss'],
  standalone: true,
  imports: [   
    CommonModule,
    FormsModule,
  ]
})
export class InsertProductAdminComponent implements OnInit {
  insertProductDTO: InsertProductDTO = {
    name: '',
    images: []
  };
  constructor(    
    private route: ActivatedRoute,
    private router: Router,
    private productService: MauBangService,    
  ) {
    
  } 
  ngOnInit() {
  } 

  onFileChange(event: any) {
    // Retrieve selected files from input element
    const files = event.target.files;
    // Limit the number of selected files to 5
    if (files.length > 5) {
      console.error('Please select a maximum of 5 images.');
      return;
    }
    // Store the selected files in the newProduct object
    this.insertProductDTO.images = files;
  }

  insertProduct() {    
    this.productService.insertProduct(this.insertProductDTO).subscribe({
      next: (apiResponse: ApiResponse) => {
        debugger
        if (this.insertProductDTO.images.length > 0) {
          const productId = apiResponse.data.id; // Assuming the response contains the newly created product's ID
          this.productService.uploadImages(productId, this.insertProductDTO.images).subscribe({
            next: (imageResponse:ApiResponse) => {
              debugger
              // Handle the uploaded images response if needed              
              console.log('Images uploaded successfully:', imageResponse.data);
              // Navigate back to the previous page
              this.router.navigate(['../'], { relativeTo: this.route });
            },
            error: (error: HttpErrorResponse) => {
              debugger;
              console.error(error?.error?.message ?? '');
            }
          })          
        }
      },
      error: (error: HttpErrorResponse) => {
        debugger;
        console.error(error?.error?.message ?? '');
      } 
    });    
  }
}
