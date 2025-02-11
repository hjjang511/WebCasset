import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { UpdateProductDTO } from '../dtos/product/update.product.dto';
import { InsertProductDTO } from '../dtos/product/insert.product.dto';
import { ApiResponse } from '../response/api.response';


@Injectable({
  providedIn: 'root'
})
export class MauBangService {
  private apiBaseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  getProducts(
    keyword: string,
    page: number,
    limit: number
  ): Observable<ApiResponse> {
    const params = {
      keyword: keyword,
      page: page.toString(),
      limit: limit.toString()
    };
    return this.http.get<ApiResponse>(`${this.apiBaseUrl}/maubangs`, { params });
  }

  getDetailProduct(productId: number): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(`${this.apiBaseUrl}/maubangs/${productId}`);
  }

  deleteProduct(productId: number): Observable<ApiResponse> {
    debugger
    return this.http.delete<ApiResponse>(`${this.apiBaseUrl}/maubangs/${productId}`);
  }
  updateProduct(productId: number, updatedProduct: UpdateProductDTO): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(`${this.apiBaseUrl}/maubangs/${productId}`, updatedProduct);
  }  
  insertProduct(insertProductDTO: InsertProductDTO): Observable<ApiResponse> {
    // Add a new product
    return this.http.post<ApiResponse>(`${this.apiBaseUrl}/maubangs`, insertProductDTO);
  }
  uploadImages(productId: number, files: File[]): Observable<ApiResponse> {
    const formData = new FormData();
    for (let i = 0; i < files.length; i++) {
      formData.append('files', files[i]);
    }
    // Upload images for the specified product id
    return this.http.post<ApiResponse>(`${this.apiBaseUrl}/maubangs/uploads/${productId}`, formData);
  }
  deleteProductImage(id: number): Observable<any> {
    debugger
    return this.http.delete<string>(`${this.apiBaseUrl}/maubang_image/${id}`);
  }
}
//update.category.admin.component.html