import { Component, OnInit } from '@angular/core';
import {AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private _auth: AuthService,
              private _router: Router) { }

  registerUserData:any = {
    username: null,
    email: null,
    password: null,
    roles: null
  }
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
  }

}
