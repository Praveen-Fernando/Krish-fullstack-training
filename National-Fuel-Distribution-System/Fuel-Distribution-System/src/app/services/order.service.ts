import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';

const orderUrl = 'http://localhost:8080/order/createOrder';
const customerUrl = 'http://localhost:8080/order/getAllOrders';
const confirmOrderUrl = 'http://localhost:8080/order/confirmOrder';
const orderstatusUrl = 'http://localhost:8080/order/viewById'; 
const scheduledUrl = 'http://localhost:8080/order/viewAll/scheduled';
const dispatchUrl = 'http://localhost:8080/order/dispatchById';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  //Create Order
  create(data: any) {
    return this.http.post(orderUrl, data);
  }

  //Order viewbyId
  getByReferenceId(orderId: any): Observable<Order[]> {
    return this.http.get<Order[]>(`${orderstatusUrl}/${orderId}`);
  }

  //Confirm Order
  confirmOrderById(orderId: any) {
    return this.http.get(`${confirmOrderUrl}/${orderId}`,orderId);
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
  dispatchOrderById(orderId: any) {
    return this.http.get(`${dispatchUrl}/${orderId}`,orderId);
  }
 }
