import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order.model';
import { OrderService } from 'src/app/services/order.service';


@Component({
  selector: 'app-dispatch-order',
  templateUrl: './dispatch-order.component.html',
  styleUrls: ['./dispatch-order.component.scss']
})
export class DispatchOrderComponent implements OnInit {
  order = {
    orderId: ''
  };
  orders?: Order[];

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.allScheduledOrders();
  }

  allScheduledOrders(): void {
    this.orderService.viewAllScheduled()
      .subscribe({
        next: (data) => {
          this.orders = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  // dispatchOrder(String: orderId): void {
  //   this.orderService.dispatchOrderById(orderId)
  //     .subscribe({
  //       next: (data) => {
  //         this.orders = data;
  //         console.log(data);
  //       },
  //       error: (e) => console.error(e)
  //     });
  // }
}
