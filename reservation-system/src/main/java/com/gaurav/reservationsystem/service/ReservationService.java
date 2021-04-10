package com.gaurav.reservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.reservationsystem.model.Reservation;
import com.gaurav.reservationsystem.repository.ReservationRepo;

@Service
public class ReservationService {
	private final ReservationRepo reservationRepo;

	@Autowired
	public ReservationService(ReservationRepo reservationRepo) {
		super();
		this.reservationRepo = reservationRepo;
	}
	
	public Reservation addReservation(Reservation reservation) {
		return reservationRepo.save(reservation);
	}
	
	public List<Reservation> findAllReservations(){
		return reservationRepo.findAll();
	}
	
	public Reservation updateReservation(Reservation reservation) {
		return reservationRepo.save(reservation);
	}
	
	public void deleteReservation(String id) {
		reservationRepo.deleteById(id);
	}
	
	public void deleteAllReservations() {
		reservationRepo.deleteAll();
	}
	
	public Reservation findByEmail(String email) {
		Reservation reservationByEmail = reservationRepo.findByEmail(email);
		return reservationByEmail;
	}
	
}
