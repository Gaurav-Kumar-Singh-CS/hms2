import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtemisComponent } from './artemis/artemis.component';
import { AuthGuard } from './auth.guard';
import { CreateGuestComponent } from './create-guest/create-guest.component';
import { FourofourComponent } from './fourofour/fourofour.component';
import { FourothreeComponent } from './fourothree/fourothree.component';
import { GuestDetailsComponent } from './guest-details/guest-details.component';
import { GuestListComponent } from './guest-list/guest-list.component';
import { GuestComponent } from './guest/guest.component';
import { InventoryComponent } from './inventory/inventory.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ReservationComponent } from './reservation/reservation.component';
import { StaffComponent } from './staff/staff.component';
import { UpdateGuestComponent } from './update-guest/update-guest.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: ArtemisComponent
  },
  {
    path: 'reservation',
    component: ReservationComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'forbidden',
    component: FourothreeComponent
  },
  {
    path: 'error',
    component: FourofourComponent
  },
  {
    path: 'guest',
    component: GuestComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'inventory',
    component: InventoryComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'staff',
    component: StaffComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**',
    component: ArtemisComponent
  },
  {
    path: 'guests', 
    component: GuestListComponent
  },
  {
    path: 'create-guest', 
    component: CreateGuestComponent
  },
  {
    path: 'update-guest', 
    component: UpdateGuestComponent
  },
  {
    path: 'guest-details/:id', 
    component: GuestDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
