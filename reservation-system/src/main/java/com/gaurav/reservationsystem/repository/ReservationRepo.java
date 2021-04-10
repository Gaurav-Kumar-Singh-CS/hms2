package com.gaurav.reservationsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.reservationsystem.model.Reservation;

@Repository
public interface ReservationRepo extends MongoRepository<Reservation, String>{

	public Reservation findByEmail(String email);

}
