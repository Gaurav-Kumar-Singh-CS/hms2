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
		List<Guest> guests = guestService.findAllGuests();
		return new ResponseEntity<>(guests, HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Guest>> getGuestById(@PathVariable("id") String id){
		Optional<Guest> guest = guestService.findGuestById(id);
		return new ResponseEntity<>(guest, HttpStatus.OK);
	}

	
	@PostMapping("/add")
	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest){
		Guest newGuest = guestService.addGuest(guest);
		return new ResponseEntity<>(newGuest, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){
		Guest updateGuest = guestService.updateGuest(guest);
		return new ResponseEntity<>(updateGuest, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteGuest(@PathVariable("id") String id){
		guestService.deleteGuest(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
