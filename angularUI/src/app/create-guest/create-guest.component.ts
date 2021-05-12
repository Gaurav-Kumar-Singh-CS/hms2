import { Component, OnInit } from '@angular/core';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-guest',
  templateUrl: './create-guest.component.html',
  styleUrls: ['./create-guest.component.css']
})
export class CreateGuestComponent implements OnInit {
alert: boolean=false;
  guest: Guest
  constructor(private guestService: GuestService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveGuest(guest){
    this.guestService.createGuest(guest).subscribe( data =>{
      console.log(data);
      this.goToGuestList();
    },
    error => console.log(error));
    this.alert = true;
  }

  goToGuestList(){
    this.router.navigate(['/guest/guests']);
  }
  
  onSubmit(addForm: NgForm){
    console.log(addForm.value);
    this.saveGuest(addForm.value);
    this.alert = true;
  }

  closeAlert(){
    this.alert = false
  }
}
