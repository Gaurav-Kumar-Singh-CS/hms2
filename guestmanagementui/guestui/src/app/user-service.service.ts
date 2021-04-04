import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }

  public doRegistration(guest){
    return this.http.post("http://localhost:8080/guest/add", guest, {responseType : "text" as "json"});
  }
}
