package com.gaurav.roommanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaurav.roommanagement.model.Room;
import com.gaurav.roommanagement.service.RoomService;


@RestController
@RequestMapping("/room")
public class RoomController {
	
	private final RoomService roomService;

	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	
	@PostMapping("/add")
	@CrossOrigin
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		Room newRoom = roomService.addRoom(room);
		return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Room> updateGuest(@RequestBody Room room){
		Room updateRoom = roomService.updateRoom(room);
		return new ResponseEntity<>(updateRoom, HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	@CrossOrigin
	public ResponseEntity<List<Room>> getAllRooms(){
		List<Room> rooms = roomService.findAllRooms();
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllRooms(){
		roomService.deleteAllRooms();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
