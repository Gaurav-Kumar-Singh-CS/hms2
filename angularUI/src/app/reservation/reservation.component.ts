import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Reservation } from '../reservation';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  alert: boolean=false
  public reservations: Reservation[];

  public editReservation: Reservation;
  public deleteReservation: Reservation;
  constructor(private reservationService: ReservationService, private _router: Router){}

  ngOnInit(){
    this.getReservations();
  }

  public getReservations(): void{
    this.reservationService.getReservations().subscribe(
      (response: Reservation[]) => {
        this.reservations = response;
      },
      (error: HttpErrorResponse) => {
        if(error.status === 403) {
          this._router.navigate(['/forbidden'])
        } else
        this._router.navigate(['/error'])
      }
    );
  }

  public onAddReservation(addForm: NgForm): void{
    document.getElementById('add-reservation-form').click();
    this.reservationService.addReservation(addForm.value).subscribe(
      (response: Reservation) => {
        console.log(response);
        this.getReservations();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
this.alert = true
  }

  public onUpdateReservation(reservation: Reservation): void{
    this.reservationService.updateReservation(reservation).subscribe(
      (response: Reservation) => {
        console.log(response);
        this.getReservations();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
this.alert=true
  }


  public onDeleteReservation(reservationId: String): void{
    this.reservationService.deleteReservation(reservationId).subscribe(
      (response: void) => {
        console.log(response);
        this.getReservations();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
this.alert = true;
  }

  public searchReservations(key: String): void{
    const results: Reservation[] = [];
    for(const reservation of this.reservations){
      if(reservation.email.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        results.push(reservation);
      }
    }
    this.reservations = results;
    if(results.length === 0 || !key){
      this.getReservations();
    }
  }


  public onOpenModal(reservation: Reservation, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'add'){
      button.setAttribute('data-target', '#addReservationModal');
    }

    if(mode === 'edit'){
      this.editReservation = reservation;
      button.setAttribute('data-target', '#updateReservationModal');
    }

    if(mode === 'delete'){
      this.deleteReservation = reservation;
      button.setAttribute('data-target', '#deleteReservationModal');
    }

    container.appendChild(button);
    button.click();


  }
  closeAlert(){
    this.alert = false
  }
}
