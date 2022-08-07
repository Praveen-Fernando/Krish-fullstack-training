import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order.model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order-status',
  templateUrl: './order-status.component.html',
  styleUrls: ['./order-status.component.scss']
})
export class OrderStatusComponent implements OnInit {
  order = {
    orderId: ''
  };
  orders?: Order[];

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
  }

  searchOrderId(orderId: String): void {
    this.orderService.getByReferenceId(orderId)
      .subscribe({
        next: (data) => {
          this.orders = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
}
