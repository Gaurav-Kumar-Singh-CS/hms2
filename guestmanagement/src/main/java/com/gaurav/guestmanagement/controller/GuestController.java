package com.gaurav.guestmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaurav.guestmanagement.model.Guest;
import com.gaurav.guestmanagement.service.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestController {
	private final GuestService guestService;

	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Guest>> getAllGuests(){
		try {
		List<Guest> guests = guestService.findAllGuests();
		return new ResponseEntity<>(guests, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Guest>> getGuestById(@PathVariable("id") String id){
		try {
		Optional<Guest> guest = guestService.findGuestById(id);
		return new ResponseEntity<>(guest, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	
	@PostMapping("/add")
	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest){
		try {
		Guest newGuest = guestService.addGuest(guest);
		return new ResponseEntity<>(newGuest, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){
		try {
		Guest updateGuest = guestService.updateGuest(guest);
		return new ResponseEntity<>(updateGuest, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteGuest(@PathVariable("id") String id){
		try {
		guestService.deleteGuest(id);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllGuests(){
		try {
		guestService.deleteAllGuests();
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/search/{name}")
	public Guest getGuestByName(@PathVariable("name") String name){
		Guest guest = guestService.findByName(name);
		return guest;
	}

}
