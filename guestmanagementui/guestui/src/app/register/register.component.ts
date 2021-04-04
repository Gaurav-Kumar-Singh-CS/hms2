import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { Guest } from '../guest';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  guest : Guest = new Guest("","","","");
  message  :any;

  constructor(private service : UserServiceService) { }

  ngOnInit(): void {
  }

  public registerNow(){
    let response = this.service.doRegistration(this.guest);
    response.subscribe(data => {
      this.message = data;
    })
  }

}
