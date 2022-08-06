import { Component, OnInit } from '@angular/core';
import { Order } from '../models/order.model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order-fuel',
  templateUrl: './order-fuel.component.html',
  styleUrls: ['./order-fuel.component.scss']
})
export class OrderFuelComponent implements OnInit {

 order = {
    fuelStationName: '',
    fuelStationNumber: '',
    fuelTypeId: '',
    fuelCapacity: ''
  };
  submitted = false;
  constructor(private orderService: OrderService) { }
  ngOnInit(): void {
  }

 saveOrder() {
    const data = {
      fuelStationName: this.order.fuelStationName,
      fuelStationNumber: this.order.fuelStationNumber,
      fuelTypeId: this.order.fuelTypeId,
      fuelCapacity: this.order.fuelCapacity
    };
    this.orderService.create(data)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
  }
  newOrder() {
    this.submitted = false;
    this.order = {
      fuelStationName: '',
      fuelStationNumber: '',
      fuelTypeId: '',
      fuelCapacity: ''
    };
  }
}
