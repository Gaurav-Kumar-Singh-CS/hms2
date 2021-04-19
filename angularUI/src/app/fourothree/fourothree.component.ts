import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-fourothree',
  templateUrl: './fourothree.component.html',
  styleUrls: ['./fourothree.component.css']
})
export class FourothreeComponent implements OnInit {

  constructor(public _authService: AuthService) { }

  ngOnInit(): void {
  }

}
