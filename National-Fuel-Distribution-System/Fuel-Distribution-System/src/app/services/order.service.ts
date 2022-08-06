import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';
const baseUrl = 'http://localhost:8080/order/createOrder';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  create(data: any) {
    return this.http.post(baseUrl, data);
  }
}
