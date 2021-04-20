import { Component, OnInit } from '@angular/core';
import { GuestService } from '../guest.service';
import { Guest } from '../guest';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-guest',
  templateUrl: './update-guest.component.html',
  styleUrls: ['./update-guest.component.css']
})
export class UpdateGuestComponent implements OnInit {

  id: string;
  guest: Guest
  constructor(private guestService: GuestService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    //this.guest = new Guest();
    this.guestService.getGuestById(this.id).subscribe( data => {
      this.guest = data;
    });
  }

  onSubmit(guest){
    this.guestService.updateGuest(guest).subscribe( data =>{
      this.goToGuestList();
    }
    , error => console.log(error));
  }

  goToGuestList(){
    this.router.navigate(['/guest/guests']);
  }
}