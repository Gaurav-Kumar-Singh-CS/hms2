import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { getTestBed, TestBed } from '@angular/core/testing';
import { Guest } from './guest';

import { GuestService } from './guest.service';

fdescribe('GuestService', () => {
  let service: GuestService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [GuestService]});
    service = TestBed.inject(GuestService);
    httpMock = getTestBed().get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all guests from http', ()=>{
    // arrange
    let dummyGuests:Guest[] = [
      {id: 'string',
        name: 'string',
        gender: 'string',
        email: 'string',
        phone: 'string',
        address: {city:'city',pin:'pin',state:'state'}}
    ];

    // act
    service.getGuestsList().subscribe(res => {
      expect(res.length).toBe(1);
      expect(res).toEqual(dummyGuests);
    });

    // http mock
    let req = httpMock.expectOne(service.getGuestsUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyGuests);
  });


  it('should get all guests from http', ()=>{
    // arrange
    let dummyGuests:Guest[] = [
      {id: 'string',
        name: 'string',
        gender: 'string',
        email: 'string',
        phone: 'string',
        address: {city:'city',pin:'pin',state:'state'}},
        {id: 'string1',
        name: 'string',
        gender: 'string',
        email: 'string',
        phone: 'string',
        address: {city:'city',pin:'pin',state:'state'}}
    ];

    // act
    service.getGuestsList().subscribe(res => {
      expect(res.length).toBe(2);
      expect(res).toEqual(dummyGuests);
    });

    // http mock
    let req = httpMock.expectOne(service.getGuestsUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyGuests);
  });


  it('should add an guest and return it', () => {
    let dummyGuests:Guest = 
    {id: 'string',
        name: 'string',
        gender: 'string',
        email: 'string',
        phone: 'string',
        address: {city:'city',pin:'pin',state:'state'}}
    ;

    service.createGuest(dummyGuests).subscribe(
      data => expect(data).toEqual(dummyGuests, 'should return the guest'),
      fail
    );

    // addGuest should have made one request to POST guest
    const req = httpMock.expectOne(service.addGuestUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyGuests);

    // Expect server to return the guest after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyGuests });
    req.event(expectedResponse);
  });


  it('should update an guest and return it', () => {
    let dummyGuests:Guest = 
    {id: 'string',
        name: 'string',
        gender: 'string',
        email: 'string',
        phone: 'string',
        address: {city:'city',pin:'pin',state:'state'}}
    ;

    service.createGuest(dummyGuests).subscribe(
      data => expect(data).toEqual(dummyGuests, 'should return the guest'),
      fail
    );

    // addGuest should have made one request to POST guest
    const req = httpMock.expectOne(service.addGuestUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyGuests);

    // Expect server to return the guest after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyGuests });
    req.event(expectedResponse);
  });
});
