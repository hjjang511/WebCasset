import { Inject, Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

import { UpdateProductDTO } from '../dtos/product/update.product.dto';
import { InsertProductDTO } from '../dtos/product/insert.product.dto';
import { ApiResponse } from '../response/api.response';
import { InsertCassetteDTO } from '../dtos/cassette/insert.cassette.dto';
import { DOCUMENT } from '@angular/common';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiBaseUrl = environment.apiBaseUrl;
  localStorage?:Storage;
  constructor( 
    private http: HttpClient,
    @Inject(DOCUMENT) private document: Document
  ) { 
    this.localStorage = document.defaultView?.localStorage;
  }


  getProductsById(productId: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(`${this.apiBaseUrl}/products/${productId}`);
  }

  getProductsByIds(productIds: number[]): Observable<ApiResponse> {
    const params = new HttpParams().set('ids', productIds.join(','));
    return this.http.get<ApiResponse>(`${this.apiBaseUrl}/products/by-ids`, { params });
  }

  insertProduct(insertCassetteDTO: InsertCassetteDTO): Observable<ApiResponse> {
    // Add a new product
    return this.http.post<ApiResponse>(`${this.apiBaseUrl}/products`, insertCassetteDTO);
  }

  saveIdOtpNametoLocal(id:number,otp:number,name:string){
    debugger
    this.localStorage?.setItem('otp', JSON.stringify(otp));
    debugger
    this.localStorage?.setItem('id', JSON.stringify(id));
    debugger
    this.localStorage?.setItem('name', JSON.stringify(name));
  }

  saveMatAMatBtoLocal(matA:string,matB:string){
    debugger
    this.localStorage?.setItem('matA', JSON.stringify(matA));
    debugger
    this.localStorage?.setItem('matB', JSON.stringify(matB));
  }


  setIdfromLocal(): number{
    const mauBang_id = Number(this.localStorage?.getItem('id')); 
    debugger
    return mauBang_id;
  }

  setOtpfromLocal(): number{
    const otpName = Number(this.localStorage?.getItem('otp')); 
    debugger
    return otpName;
  }

  setNamefromLocal(): string{
    const Name = String(this.localStorage?.getItem('name')); 
    debugger
    return Name;
  }
  removeProductFromLocalStorage():void {
    try {
      // Remove the user data from local storage using the key
      this.localStorage?.removeItem('id');
      this.localStorage?.removeItem('otp');
      this.localStorage?.removeItem('name');
      this.localStorage?.removeItem('matA');
      this.localStorage?.removeItem('matB');
      console.log('Product data removed from local storage.');
    } catch (error) {
      console.error('Error removing user data from local storage:', error);
      // Handle the error as needed
    }
  }
}
//update.category.admin.component.html