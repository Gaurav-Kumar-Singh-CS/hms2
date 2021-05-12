import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { InventoryService } from '../inventory.service';
import { Room } from '../room';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {
alert: boolean=false;
  public rooms: Room[];

  public editRoom: Room;
  constructor(private roomService: InventoryService, private _router: Router){}

  ngOnInit(){
    this.getRooms();
  }

  public getRooms(): void{
    this.roomService.getRooms().subscribe(
      (response: Room[]) => {
        this.rooms = response;
      },
      (error: HttpErrorResponse) => {
        if(error.status === 403) {
          this._router.navigate(['/forbidden'])
        } else
        this._router.navigate(['/error'])
      }
    );
  }

  public onAddRoom(addForm: NgForm): void{
    document.getElementById('add-room-form').click();
    this.roomService.addRoom(addForm.value).subscribe(
      (response: Room) => {
        console.log(response);
        this.getRooms();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
    this.alert = true;
  }

  public onUpdateRoom(room: Room): void{
    this.roomService.updateRoom(room).subscribe(
      (response: Room) => {
        console.log(response);
        this.getRooms();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    this.alert = true;
  }



  public onOpenModal(room: Room, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'add'){
      button.setAttribute('data-target', '#addRoomModal');
    }

    if(mode === 'edit'){
      this.editRoom = room;
      button.setAttribute('data-target', '#updateRoomModal');
    }

    container.appendChild(button);
    button.click();


  }

  closeAlert(){
    this.alert = false
  }

}
