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
import { GuestListComponent } from './guest-list/guest-list.component';
import { GuestDetailsComponent } from './guest-details/guest-details.component';
import { CreateGuestComponent } from './create-guest/create-guest.component';
import { UpdateGuestComponent } from './update-guest/update-guest.component';
import { GuestService } from './guest.service';
import { ArtemisOneComponent } from './artemis-one/artemis-one.component';
import { ArtemisTwoComponent } from './artemis-two/artemis-two.component';
import { ArtemisThreeComponent } from './artemis-three/artemis-three.component';
import { ArtemisFourComponent } from './artemis-four/artemis-four.component';
import { InventoryService } from './inventory.service';
import { ReservationService } from './reservation.service';
import { PaymentComponent } from './payment/payment.component';

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
    FourothreeComponent,
    GuestListComponent,
    GuestDetailsComponent,
    CreateGuestComponent,
    UpdateGuestComponent,
    ArtemisOneComponent,
    ArtemisTwoComponent,
    ArtemisThreeComponent,
    ArtemisFourComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MaterialModule,
    BrowserAnimationsModule
  ],
  providers: [AuthService, AuthGuard, StaffService, GuestService, InventoryService, ReservationService,
  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
