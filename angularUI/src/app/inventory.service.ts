import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Room } from './room';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  
  public getRoomsUrl = "http://localhost:8762/room/room/all";
  public addRoomUrl = "http://localhost:8762/room/room/add";
  private apiServerUrl = "http://localhost:8762/room";
  constructor(private http: HttpClient) { }

  public getRooms(): Observable<Room[]>{
    return this.http.get<Room[]>(`${this.apiServerUrl}/room/all`)
  }

  public addRoom(room: Room): Observable<Room>{
    console.log(room)
    return this.http.post<Room>(`${this.apiServerUrl}/room/add`, room);
  }

  public updateRoom(room: Room): Observable<Room>{
    console.log(room)
    return this.http.put<Room>(`${this.apiServerUrl}/room/update`, room);
  }
}
