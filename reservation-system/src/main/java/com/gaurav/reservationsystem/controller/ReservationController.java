package com.gaurav.reservationsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaurav.reservationsystem.model.Reservation;
import com.gaurav.reservationsystem.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	private final ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	
	
	@GetMapping("/all")
	@CrossOrigin
	public ResponseEntity<List<Reservation>> getAllReservations(){
		List<Reservation> reservations = reservationService.findAllReservations();
		return new ResponseEntity<>(reservations, HttpStatus.OK);
	}

	
	@PostMapping("/add")
	@CrossOrigin
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
		Reservation newReservation = reservationService.addReservation(reservation);
		return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
		Reservation updateReservation = reservationService.updateReservation(reservation);
		return new ResponseEntity<>(updateReservation, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteReservation(@PathVariable("id") String id){
		reservationService.deleteReservation(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllReservations(){
		reservationService.deleteAllReservations();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/search/{email}")
	public Reservation getReservationByEmail(@PathVariable("email") String email){
		Reservation reservation = reservationService.findByEmail(email);
		return reservation;
	}

}

