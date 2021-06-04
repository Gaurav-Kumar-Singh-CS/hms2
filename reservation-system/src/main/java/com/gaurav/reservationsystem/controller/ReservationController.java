package com.gaurav.reservationsystem.controller;
				
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaurav.reservationsystem.config.MessagingConfig;
import com.gaurav.reservationsystem.model.Reservation;
import com.gaurav.reservationsystem.service.ReservationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
    private RabbitTemplate template;
	
	private final ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
/*	
	@Autowired
	private RestTemplate restTemplate;
				
	@Autowired
	private WebClient.Builder webClientBuilder;
									
	@RequestMapping("/{userId}")
		public List<GuestItem> getGuest(@PathVariable("userId") String userId){
		Guest guests = restTemplate.getForObject("http://guest-management/guest/"+userId, Guest.class);
				
		return guests.getGuest().stream().map(guest ->{
			Guest guest1 = restTemplate.getForObject("http://guest-management/guests/" + guest.getGuest(), Guest.class);
			
			return new GuestItem(guest.getName(),"full time",guest.getName());
			})
		.collect(Collectors.toList());
		
	}
*/


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
		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, newReservation);
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

