import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from './reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  
  public getReservationsUrl = "http://localhost:8762/reservation/reservation/all";
  public addReservationUrl = "http://localhost:8762/reservation/reservation/add";
  private apiServerUrl = "http://localhost:8762/reservation";
  constructor(private http: HttpClient) { }

  public getReservations(): Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${this.apiServerUrl}/reservation/all`)
  }

  public addReservation(reservation: Reservation): Observable<Reservation>{
    console.log(reservation)
    return this.http.post<Reservation>(`${this.apiServerUrl}/reservation/add`, reservation);
  }

  public updateReservation(reservation: Reservation): Observable<Reservation>{
    console.log(reservation)
    return this.http.put<Reservation>(`${this.apiServerUrl}/reservation/update`, reservation);
  }

  public deleteReservation(reservationId: String): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/reservation/delete/${reservationId}`);
  }
}
