package com.gaurav.guestmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.guestmanagement.model.Guest;
import com.gaurav.guestmanagement.repository.GuestRepo;

@Service
public class GuestService {
	private final GuestRepo guestRepo;

	@Autowired
	public GuestService(GuestRepo guestRepo) {
		super();
		this.guestRepo = guestRepo;
	}
	
	public Guest addGuest(Guest guest) {
		return guestRepo.save(guest);
	}
	
	public List<Guest> findAllGuests(){
		return guestRepo.findAll();
	}
	
	public Guest updateGuest(Guest guest) {
		return guestRepo.save(guest);
	}
	
	public Optional<Guest> findGuestById(String id) {
		Optional<Guest> guestById = guestRepo.findById(id);
		return guestById;
	}
	
	public void deleteGuest(String id) {
		guestRepo.deleteById(id);
	}

}
