import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order.model';
import { OrderService } from 'src/app/services/order.service';
import { RouterLink } from '@angular/router';
import { Routes, RouterModule } from '@angular/router'; 

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

  confirmOrder(orderId:String): void{
    this.orderService.confirmOrderById(orderId).subscribe({
      next: (res) => {
        console.log(orderId);
        window.location.reload();
      }
    });
  }
}
