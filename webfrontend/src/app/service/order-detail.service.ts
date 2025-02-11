import { MauBangService } from './maubang.service';
import { Injectable } from '@angular/core';
import { 
  HttpClient, 
  HttpParams, 
  HttpHeaders 
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { OrderDTO } from '../dtos/order/order.dto';
import { ApiResponse } from '../response/api.response';
import { OrderDetailDTO } from '../dtos/order/order-detail.dto';


@Injectable({
  providedIn: 'root',
})
export class OrderDetailService {
  private apiUrl = `${environment.apiBaseUrl}/order_details`;


  constructor(private http: HttpClient) {}

  placeOrder(orderData: OrderDetailDTO): Observable<ApiResponse> {    
    // Gửi yêu cầu đặt hàng
    return this.http.post<ApiResponse>(this.apiUrl, orderData);
  }
  getOrderById(orderId: number): Observable<ApiResponse> {
    const url = `${environment.apiBaseUrl}/orders/${orderId}`;
    return this.http.get<ApiResponse>(url);
  }
  getProductsByIds(productIds: number[]): Observable<ApiResponse> {
    const params = new HttpParams().set('ids', productIds.join(','));
    return this.http.get<ApiResponse>(`${environment.apiBaseUrl}/order_details/by-ids`, { params });
  }

}
