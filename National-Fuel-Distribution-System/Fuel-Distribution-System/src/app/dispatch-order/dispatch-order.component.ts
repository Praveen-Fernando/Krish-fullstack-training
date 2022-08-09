import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order.model';
import { OrderService } from 'src/app/services/order.service';
import { RouterLink } from '@angular/router';
import { Routes, RouterModule } from '@angular/router'; 

@Component({
  selector: 'app-dispatch-order',
  templateUrl: './dispatch-order.component.html',
  styleUrls: ['./dispatch-order.component.scss']
})
export class DispatchOrderComponent implements OnInit {
  filteredOrders:Order[]=[];
  display = ['orderId'];
  orders: Order[]=[];
  order: any;

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

  dispatchOrder(orderId:String): void{
    this.orderService.dispatchOrderById(orderId).subscribe({
      next: (res) => {
        console.log(orderId);
        window.location.reload();
      }
    });
  }
}

