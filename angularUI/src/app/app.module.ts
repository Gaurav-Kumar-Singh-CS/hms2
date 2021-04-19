import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ArtemisComponent } from './artemis/artemis.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { GuestComponent } from './guest/guest.component';
import { InventoryComponent } from './inventory/inventory.component';
import { StaffComponent } from './staff/staff.component';
import { ReservationComponent } from './reservation/reservation.component';
import { AuthService } from './auth.service';
import { AuthGuard } from './auth.guard';
import { TokenInterceptorService } from './token-interceptor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { StaffService } from './staff.service';
import { FourofourComponent } from './fourofour/fourofour.component';
import { FourothreeComponent } from './fourothree/fourothree.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    ArtemisComponent,
    HeaderComponent,
    FooterComponent,
    GuestComponent,
    InventoryComponent,
    StaffComponent,
    ReservationComponent,
    FourofourComponent,
    FourothreeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MaterialModule,
    BrowserAnimationsModule
  ],
  providers: [AuthService, AuthGuard, StaffService,
  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
