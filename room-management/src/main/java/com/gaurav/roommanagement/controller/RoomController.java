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
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		try {
			Room newRoom = roomService.addRoom(room);
			return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Room> updateGuest(@RequestBody Room room){
		try {
		Room updateRoom = roomService.updateRoom(room);
		return new ResponseEntity<>(updateRoom, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Room>> getAllRooms(){
		try {
		List<Room> rooms = roomService.findAllRooms();
		return new ResponseEntity<>(rooms, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllRooms(){
		try {
		roomService.deleteAllRooms();
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	

}
