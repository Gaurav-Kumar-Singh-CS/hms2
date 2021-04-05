import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-artemis',
  templateUrl: './artemis.component.html',
  styleUrls: ['./artemis.component.css']
})
export class ArtemisComponent implements OnInit {

  athens = "/assets/images/athens.jpg";
  greece = "/assets/images/greece1.jpg";
  thumbnail = "/assets/images/thumbnail.png";

  constructor() { }

  ngOnInit(): void {
  }

}
