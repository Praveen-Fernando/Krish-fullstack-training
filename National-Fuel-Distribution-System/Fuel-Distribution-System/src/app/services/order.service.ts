import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';

const orderUrl = 'http://localhost:8080/order/createOrder';
const customerUrl = 'http://localhost:8082/scheduled/viewAll';
const orderstatusUrl = 'http://localhost:8082/scheduled/viewById'
const dispatchUrl = 'http://localhost:8083/scheduled/viewAll';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  create(data: any) {
    return this.http.post(orderUrl, data);
  }

  getOrderId(orderId: any): Observable<Order> {
    return this.http.get(`${orderUrl}/${orderId}`);
  }


  getAll(): Observable<Order[]> {
    return this.http.get<Order[]>(customerUrl);
  }

  getByReferenceId(orderId: any): Observable<Order[]> {
    return this.http.get<Order[]>(`${orderstatusUrl}/${orderId}`);
  }
}
