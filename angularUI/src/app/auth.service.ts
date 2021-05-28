import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

function _window() : any{
  return window;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  get nativeWindow(): any{
    return _window();
  }

  private _registerUrl = "http://localhost:8762/api/auth/signup";
  private _loginUrl = "http://localhost:8762/api/auth/signin";
  constructor(private http: HttpClient, private _router: Router) { }

  registerUser(user) {
    return this.http.post<any>(this._registerUrl, user)
  }

  loginUser(user) {
    return this.http.post<any>(this._loginUrl, user)
  }

  loggedIn() {
    return !!localStorage.getItem('token')
  }

  logoutUser() {
    localStorage.removeItem('token')
    this._router.navigate(['/home'])

  }

  getToken() {
    return localStorage.getItem('token')
  }

}
