package com.gaurav.roommanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.roommanagement.model.Room;
import com.gaurav.roommanagement.repository.RoomRepo;

@Service
public class RoomService {
	private final RoomRepo roomRepo;
	
	@Autowired
	public RoomService(RoomRepo roomRepo) {
		super();
		this.roomRepo = roomRepo;
	}
	
	public Room addRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public List<Room> findAllRooms(){
		return roomRepo.findAll();
	}
	
	public Room updateRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public void deleteAllRooms() {
		roomRepo.deleteAll();
	}
	

}
