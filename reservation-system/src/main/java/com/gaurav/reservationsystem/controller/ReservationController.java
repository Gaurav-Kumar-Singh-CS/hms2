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
	public ResponseEntity<List<Reservation>> getAllReservations(){
		try {
		List<Reservation> reservations = reservationService.findAllReservations();
		return new ResponseEntity<>(reservations, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	
	@PostMapping("/add")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
		try {
		Reservation newReservation = reservationService.addReservation(reservation);
		return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
		try {
		Reservation updateReservation = reservationService.updateReservation(reservation);
		return new ResponseEntity<>(updateReservation, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteReservation(@PathVariable("id") String id){
		try {
		reservationService.deleteReservation(id);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllReservations(){
		try {
		reservationService.deleteAllReservations();
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/search/{email}")
	public Reservation getReservationByEmail(@PathVariable("email") String email){
		Reservation reservation = reservationService.findByEmail(email);
		return reservation;
		
	}

}

