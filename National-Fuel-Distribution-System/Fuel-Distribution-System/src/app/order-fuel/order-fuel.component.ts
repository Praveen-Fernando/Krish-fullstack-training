import { Component, OnInit, Output } from '@angular/core';
import { Order } from '../models/order.model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order-fuel',
  templateUrl: './order-fuel.component.html',
  styleUrls: ['./order-fuel.component.scss']
})
export class OrderFuelComponent implements OnInit {
alert:boolean = false;
orders?: Order[];

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
      fuelCapacity: this.order.fuelCapacity,
    };
    this.orderService.create(data)
    .subscribe({
      next: (res) => {
        console.log(res);
        const r = JSON.stringify(res);    
        var re = JSON.parse(r);
        var orderId = re.orderId;
        alert('Your Referance ID : ' + orderId);
        this.submitted = true;
        this.alert = true;
      },
      error: (e) => console.error(e)
    });
  }
  closeAlert(){
  this.alert = false;
}
}

// getOrderId(OrderId: String) {

//   this.orderService.getOrderId(orderId)
//   .subscribe({
//     next: (data) => {
//       this.orders = data;
//       console.log(data);
//     },
//     error: (e) => console.error(e)
//   });
// }
