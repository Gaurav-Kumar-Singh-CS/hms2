import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllUsersComponent } from './all-users/all-users.component';
import { ArtemisComponent } from './artemis/artemis.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {
    path: "", redirectTo : "artemis", pathMatch: "full"
  },
  {
    path: "search", component : SearchComponent
  },
  {
    path: "all-users", component : AllUsersComponent
  },
  {
    path: "register", component : RegisterComponent
  },
  {
    path: "artemis", component : ArtemisComponent
  },
  {
    path: "**", component : ArtemisComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
