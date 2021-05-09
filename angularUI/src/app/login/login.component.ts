import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  alert: boolean=false
  registerUserData:any = {
    username: null,
    email: null,
    password: null,
    roles: null
  }
  constructor(private _auth: AuthService,
              private _router: Router) { }

  ngOnInit(): void {
  }
  
  registerUser() {
    this.registerUserData.roles = this.registerUserData.roles.split()
    const { username, email, password, roles } = this.registerUserData;
    this._auth.registerUser(this.registerUserData)
      .subscribe(
        res => {
          console.log(res)
          this._router.navigate(['/login'])
        },
        err => console.log(err)
      )
      this.alert = true;
  }

  closeAlert(){
    this.alert = false
  }
}
