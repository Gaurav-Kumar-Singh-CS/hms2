import { getTestBed, TestBed } from '@angular/core/testing';

import { StaffService } from './staff.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Employee } from './employee';
import { HttpEvent, HttpEventType, HttpResponse } from '@angular/common/http';
fdescribe('StaffService', () => {
  let service: StaffService;
  let httpMock: HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [StaffService]
    });
    service = TestBed.inject(StaffService);
    httpMock = getTestBed().get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all employees from http', ()=>{
    // arrange
    let dummyEmployees:Employee[] = [
      {id:'a', name:'name', email: '',
      jobTitle: '',
      phone: '',
      address: {city:'city',pin:'pin',state:'state'},
      salary: 1}
    ];

    // act
    service.getEmployees().subscribe(res => {
      expect(res.length).toBe(1);
      expect(res).toEqual(dummyEmployees);
    });

    // http mock
    let req = httpMock.expectOne(service.getEmployeesUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyEmployees);
  });


  it('should get all employees from http', ()=>{
    // arrange
    let dummyEmployees:Employee[] = [
      {id:'a', name:'name', email: '',
      jobTitle: '',
      phone: '',
      address: {city:'city',pin:'pin',state:'state'},
      salary: 1},
      {id:'b', name:'name', email: '',
      jobTitle: '',
      phone: '',
      address: {city:'city',pin:'pin',state:'state'},
      salary: 1}
    ];

    // act
    service.getEmployees().subscribe(res => {
      expect(res.length).toBe(2);
      expect(res).toEqual(dummyEmployees);
    });

    // http mock
    let req = httpMock.expectOne(service.getEmployeesUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyEmployees);
  });


  it('should add an employee and return it', () => {
    let dummyEmployees:Employee = 
      {id:'a', name:'name', email: '',
      jobTitle: '',
      phone: '',
      address: {city:'city',pin:'pin',state:'state'},
      salary: 1}
    ;

    service.addEmployee(dummyEmployees).subscribe(
      data => expect(data).toEqual(dummyEmployees, 'should return the employee'),
      fail
    );

    // addEmploye should have made one request to POST employee
    const req = httpMock.expectOne(service.addEmployeeUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyEmployees);

    // Expect server to return the employee after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyEmployees });
    req.event(expectedResponse);
  });


  it('should update an employee and return it', () => {
    let dummyEmployees:Employee = 
      {id:'b', name:'name', email: '',
      jobTitle: '',
      phone: '',
      address: {city:'city',pin:'pin',state:'state'},
      salary: 1}
    ;

    service.addEmployee(dummyEmployees).subscribe(
      data => expect(data).toEqual(dummyEmployees, 'should return the employee'),
      fail
    );

    // addEmploye should have made one request to POST employee
    const req = httpMock.expectOne(service.addEmployeeUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyEmployees);

    // Expect server to return the employee after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyEmployees });
    req.event(expectedResponse);
  });



});
