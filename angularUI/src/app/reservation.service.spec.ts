import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { getTestBed, TestBed } from '@angular/core/testing';
import { Reservation } from './reservation';

import { ReservationService } from './reservation.service';

fdescribe('ReservationService', () => {
  let service: ReservationService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ReservationService]
    });
    service = TestBed.inject(ReservationService);
    httpMock = getTestBed().get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all reservations from http', ()=>{
    // arrange
    let dummyReservations:Reservation[] = [
      {id: 'string',
        email: 'string',
        checkIn: 'string',
        checkOut: 'string',
        numberOfAdults: 1,
        numberOfChildren: 2,
        roomType: 'string',
      totalCost: new Float32Array(12)}
    ];

    // act
    service.getReservations().subscribe(res => {
      expect(res.length).toBe(1);
      expect(res).toEqual(dummyReservations);
    });

    // http mock
    let req = httpMock.expectOne(service.getReservationsUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyReservations);
  });


  it('should get all reservations from http', ()=>{
    // arrange
    let dummyReservations:Reservation[] = [
      {id: 'string',
        email: 'string',
        checkIn: 'string',
        checkOut: 'string',
        numberOfAdults: 1,
        numberOfChildren: 2,
        roomType: 'string',
      totalCost: new Float32Array(12)},
      {id: 'string2',
        email: 'string',
        checkIn: 'string',
        checkOut: 'string',
        numberOfAdults: 1,
        numberOfChildren: 2,
        roomType: 'string',
      totalCost: new Float32Array(12)}
    ];

    // act
    service.getReservations().subscribe(res => {
      expect(res.length).toBe(2);
      expect(res).toEqual(dummyReservations);
    });

    // http mock
    let req = httpMock.expectOne(service.getReservationsUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyReservations);
  });


  it('should add an reservation and return it', () => {
    let dummyReservations:Reservation = 
    {id: 'string',
    email: 'string',
    checkIn: 'string',
    checkOut: 'string',
    numberOfAdults: 1,
    numberOfChildren: 2,
    roomType: 'string',
  totalCost: new Float32Array(12)}
    ;

    service.addReservation(dummyReservations).subscribe(
      data => expect(data).toEqual(dummyReservations, 'should return the reservation'),
      fail
    );

    // addReservation should have made one request to POST reservation
    const req = httpMock.expectOne(service.addReservationUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyReservations);

    // Expect server to return the reservation after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyReservations });
    req.event(expectedResponse);
  });


  it('should update an reservation and return it', () => {
    let dummyReservations:Reservation = 
    {id: 'string',
    email: 'string',
    checkIn: 'string',
    checkOut: 'string',
    numberOfAdults: 1,
    numberOfChildren: 2,
    roomType: 'string',
  totalCost: new Float32Array(12)}
    ;

    service.addReservation(dummyReservations).subscribe(
      data => expect(data).toEqual(dummyReservations, 'should return the reservation'),
      fail
    );

    // addEmploye should have made one request to POST reservation
    const req = httpMock.expectOne(service.addReservationUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyReservations);

    // Expect server to return the reservation after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyReservations });
    req.event(expectedResponse);
  });

});
