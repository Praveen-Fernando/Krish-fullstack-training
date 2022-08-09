import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderFuelComponent } from './order-fuel/order-fuel.component';
import { OrderStatusComponent } from './order-status/order-status.component';
import { CustomerComponent } from './customer/customer.component';
import { DispatchOrderComponent } from './dispatch-order/dispatch-order.component';

const routes: Routes = [
  { path: 'order', component: OrderFuelComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
