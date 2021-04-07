package com.gaurav.roommanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.roommanagement.model.Room;

@Repository
public interface RoomRepo extends MongoRepository<Room, String>{


}
