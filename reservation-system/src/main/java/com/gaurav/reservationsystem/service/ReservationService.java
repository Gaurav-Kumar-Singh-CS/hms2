package com.gaurav.reservationsystem.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
		
		int totalPeople = reservation.getNumberOfAdults() + reservation.getNumberofChildren();
		String dateBeforeString = reservation.getCheckIn();
		String dateAfterString = reservation.getCheckOut();
		
		LocalDate dateBefore = LocalDate.parse(dateBeforeString);
		LocalDate dateAfter = LocalDate.parse(dateAfterString);
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		float totalCostSwitchCase;
		String roomTypeForSwitchCase = reservation.getRoomType();
		switch(roomTypeForSwitchCase)
		{
		case "SAC":
		totalCostSwitchCase = totalPeople * 4000 * noOfDaysBetween;
		break;
		case "SNAC":
		totalCostSwitchCase = totalPeople * 3500 * noOfDaysBetween;
		break;
		case "DAC":
		totalCostSwitchCase = totalPeople * 7000 * noOfDaysBetween;
		break;
		case "DNAC":
		totalCostSwitchCase = totalPeople * 6500 * noOfDaysBetween;
		break;
		default:
		totalCostSwitchCase = totalPeople * 4000 * noOfDaysBetween;
		}
		reservation.setTotalCost(totalCostSwitchCase);
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
