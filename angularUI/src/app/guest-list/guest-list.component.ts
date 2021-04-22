import { Component, OnInit } from '@angular/core';
import { Guest } from '../guest'
import { GuestService } from '../guest.service'
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-guest-list',
  templateUrl: './guest-list.component.html',
  styleUrls: ['./guest-list.component.css']
})
export class GuestListComponent implements OnInit {

  guests: Guest[];
  guest: Guest 

  constructor(private guestService: GuestService,
    private router: Router) { }

  ngOnInit(): void {
    this.getGuests();
  }

  private getGuests(){
    this.guestService.getGuestsList().subscribe(data => {
      this.guests = data;
    },
    (error: HttpErrorResponse) => {
      if(error.status === 403) {
        this.router.navigate(['/forbidden'])
      } else
      this.router.navigate(['/error'])
    }
    );
  }

  guestDetails(id: string){
    this.router.navigate(['/guest/guest-details', id]);
  }

  updateGuest(id: string){
    this.router.navigate(['/guest/update-guest', id]);
  }

  deleteGuest(id: string){
    this.guestService.deleteGuest(id).subscribe( data => {
      console.log(data);
      this.getGuests();
    })
  }
}