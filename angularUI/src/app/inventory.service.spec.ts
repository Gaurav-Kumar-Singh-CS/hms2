import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { getTestBed, TestBed } from '@angular/core/testing';

import { InventoryService } from './inventory.service';
import { Room } from './room';

fdescribe('InventoryService', () => {
  let service: InventoryService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [InventoryService]});
    service = TestBed.inject(InventoryService);
    httpMock = getTestBed().get(HttpTestingController);
    
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all rooms from http', ()=>{
    // arrange
    let dummyRooms:Room[] = [
      {id: 'string',
        roomType: 'string',
        cost: 1,
        totalRooms: 2}
    ];

    // act
    service.getRooms().subscribe(res => {
      expect(res.length).toBe(1);
      expect(res).toEqual(dummyRooms);
    });

    // http mock
    let req = httpMock.expectOne(service.getRoomsUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyRooms);
  });


  it('should get all rooms from http', ()=>{
    // arrange
    let dummyRooms:Room[] = [
      {id: 'string',
      roomType: 'string',
      cost: 1,
      totalRooms: 2},
      {id: 'string1',
        roomType: 'string',
        cost: 1,
        totalRooms: 2}
    ];

    // act
    service.getRooms().subscribe(res => {
      expect(res.length).toBe(2);
      expect(res).toEqual(dummyRooms);
    });

    // http mock
    let req = httpMock.expectOne(service.getRoomsUrl);
    expect(req.request.method).toBe("GET");
    req.flush(dummyRooms);
  });


  it('should add an room and return it', () => {
    let dummyRooms:Room = 
    {id: 'string',
        roomType: 'string',
        cost: 1,
        totalRooms: 2}
    ;

    service.addRoom(dummyRooms).subscribe(
      data => expect(data).toEqual(dummyRooms, 'should return the room'),
      fail
    );

    // addRoom should have made one request to POST room
    const req = httpMock.expectOne(service.addRoomUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyRooms);

    // Expect server to return the room after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyRooms });
    req.event(expectedResponse);
  });


  it('should update an room and return it', () => {
    let dummyRooms:Room = 
    {id: 'string',
        roomType: 'string',
        cost: 1,
        totalRooms: 2}
    ;

    service.addRoom(dummyRooms).subscribe(
      data => expect(data).toEqual(dummyRooms, 'should return the room'),
      fail
    );

    // addRoom should have made one request to POST room
    const req = httpMock.expectOne(service.addRoomUrl);
    expect(req.request.method).toEqual('POST');
    expect(req.request.body).toEqual(dummyRooms);

    // Expect server to return the room after POST
    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created', body: dummyRooms });
    req.event(expectedResponse);
  });
});
