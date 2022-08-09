import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router'; // CLI imports router
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderFuelComponent } from './order-fuel/order-fuel.component';
import { OrderStatusComponent } from './order-status/order-status.component';
import { CustomerComponent } from './customer/customer.component';
import { DispatchOrderComponent } from './dispatch-order/dispatch-order.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    OrderFuelComponent,
    OrderStatusComponent,
    CustomerComponent,
    DispatchOrderComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    Ng2SearchPipeModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'orderFuel', component: OrderFuelComponent},
      {path: 'orderStatus', component: OrderStatusComponent},
      {path: 'customers', component: CustomerComponent},
      {path: 'dispatch', component: DispatchOrderComponent},
      {path: 'home', component: HomeComponent},
      {path: '', redirectTo: 'home', pathMatch: 'full'}
    ]),
  ],

  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }


