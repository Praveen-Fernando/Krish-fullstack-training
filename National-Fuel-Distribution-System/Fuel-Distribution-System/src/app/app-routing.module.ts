import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderFuelComponent } from './order-fuel/order-fuel.component';
import { OrderConfirmComponent } from './order-confirm/order-confirm.component';
import { OrderStatusComponent } from './order-status/order-status.component';
import { CustomerComponent } from './customer/customer.component';
import { DispatchOrderComponent } from './dispatch-order/dispatch-order.component';

const routes: Routes = [
  // { path: '', redirectTo: 'order', pathMatch: 'full' },
  { path: 'order', component: OrderFuelComponent },
  // { path: 'order/:id', component: OrderConfirmComponent },
  // { path: 'orders', component: OrderStatusComponent },
  // { path: 'dispatch', component: DispatchOrderComponent },
  // { path: 'customers', component: CustomerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
