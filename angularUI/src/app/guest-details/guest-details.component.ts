import { Component, OnInit } from '@angular/core';
import { Guest } from '../guest';
import { ActivatedRoute } from '@angular/router';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-guest-details',
  templateUrl: './guest-details.component.html',
  styleUrls: ['./guest-details.component.css']
})
export class GuestDetailsComponent implements OnInit {

  id: string
  guest: Guest
  constructor(private route: ActivatedRoute, private guestService: GuestService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.guest = new Guest();
    this.guestService.getGuestById(this.id).subscribe( data => {
      this.guest = data;
    });
  }

}