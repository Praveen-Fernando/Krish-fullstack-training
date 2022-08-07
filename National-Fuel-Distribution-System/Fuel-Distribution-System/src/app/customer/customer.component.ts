import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order.model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {
  
  orders?: Order[];
  currentTutorial: Order = {};
  currentIndex = -1;
  title = '';

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.retrieveOrders();
  }

  retrieveOrders(): void {
    this.orderService.getAll()
      .subscribe({
        next: (data) => {
          this.orders = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
}
