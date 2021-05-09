import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
@Injectable({
  providedIn: 'root'
})
export class StaffService {
  public getEmployeesUrl = "http://localhost:8762/staff/staff/all";
  public addEmployeeUrl = "http://localhost:8762/staff/staff/add";
  private apiServerUrl = "http://localhost:8762/staff";
  constructor(private http: HttpClient) { }

  public getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/staff/all`)
  }

  public addEmployee(employee: Employee): Observable<Employee>{
    console.log(employee)
    return this.http.post<Employee>(`${this.apiServerUrl}/staff/add`, employee);
  }

  public updateEmployee(employee: Employee): Observable<Employee>{
    console.log(employee)
    return this.http.put<Employee>(`${this.apiServerUrl}/staff/update`, employee);
  }

  public deleteEmployee(employeeId: String): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/staff/delete/${employeeId}`);
  }
}
