import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtemisComponent } from './artemis/artemis.component';
import { AuthGuard } from './auth.guard';
import { GuestComponent } from './guest/guest.component';
import { InventoryComponent } from './inventory/inventory.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ReservationComponent } from './reservation/reservation.component';
import { StaffComponent } from './staff/staff.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
