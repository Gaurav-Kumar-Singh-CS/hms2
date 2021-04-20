import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-artemis-four',
  templateUrl: './artemis-four.component.html',
  styleUrls: ['./artemis-four.component.css']
})
export class ArtemisFourComponent implements OnInit {

  loginUserData:any = {}
  constructor(private _auth: AuthService,
              private _router: Router) { }

  ngOnInit(): void {
  }
  
  loginUser() {
    this._auth.loginUser(this.loginUserData)
      .subscribe(
        res => {
          console.log(res),
          localStorage.setItem('token', res.accessToken)
          this._router.navigate(['/home'])
        },
        err => console.log(err)
      )
  }

}
