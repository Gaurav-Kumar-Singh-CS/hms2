package com.gaurav.guestmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.guestmanagement.model.Guest;

@Repository
public interface GuestRepo extends MongoRepository<Guest, String> {

}
