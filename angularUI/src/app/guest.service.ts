import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Guest } from './guest';

@Injectable({
  providedIn: 'root'
})
export class GuestService {

  private baseURL = "http://localhost:8762/guest";

  constructor(private httpClient: HttpClient) { }
  
  getGuestsList(): Observable<Guest[]>{
    return this.httpClient.get<Guest[]>(`${this.baseURL}/guest/all`);
  }

  createGuest(guest: Guest): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/guest/add`, guest);
  }

  getGuestById(id: string): Observable<Guest>{
    return this.httpClient.get<Guest>(`${this.baseURL}/guest/find/${id}`);
  }

  updateGuest(guest: Guest): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/guest/update`, guest);
  }

  deleteGuest(id: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/guest/delete/${id}`);
  }

  deleteAllGuests(): Observable<Guest[]>{
    return this.httpClient.delete<Guest[]>(`${this.baseURL}/guest/delete/all`);
  }
}