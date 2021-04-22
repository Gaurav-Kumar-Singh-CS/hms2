import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-guest',
  templateUrl: './guest.component.html',
  styleUrls: ['./guest.component.css']
})
export class GuestComponent implements OnInit {

  title = "Guest Management"
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.router.navigate(['/guest/guests'])
  }

}
