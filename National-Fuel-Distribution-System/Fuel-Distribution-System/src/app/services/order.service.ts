import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';

const orderUrl = 'http://localhost:8080/order/createOrder';
const customerUrl = 'http://localhost:8080/order/getAllOrders';
const orderstatusUrl = 'http://localhost:8080/order/viewById'; 
const scheduledUrl = 'http://localhost:8080/order/viewAll/scheduled';
const dispatchUrl = 'http://localhost:8083/dispatch';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  //Create Order
  create(data: any) {
    return this.http.post(orderUrl, data);
  }

  
  // getOrderId(orderId: any): Observable<Order> {
  //   return this.http.get(`${orderUrl}/${orderId}`);
  // }

  //Order viewbyId
  getByReferenceId(orderId: any): Observable<Order[]> {
    return this.http.get<Order[]>(`${orderstatusUrl}/${orderId}`);
  }

  //Customers ViewAllOrders 
  getAll(): Observable<Order[]> {
    return this.http.get<Order[]>(customerUrl);
  }

 //Dispatch
  viewAllScheduled(): Observable<Order[]> {
    return this.http.get<Order[]>(scheduledUrl);
  }

  //dispatch order
//   dispatchOrderById(orderId: any): Observable<Order[]> {
//     return this.http.put(`${dispatchUrl}/${orderId}`);
//   }
 }
