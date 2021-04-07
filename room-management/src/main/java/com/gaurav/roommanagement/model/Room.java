package com.gaurav.roommanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "room")
public class Room {
	
	@Id
	public String id;
	public String roomType;
	public String cost;
	public int totalRooms;
	
	public Room() {}

	public Room(String id, String roomType, String cost, int totalRooms) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.cost = cost;
		this.totalRooms = totalRooms;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	
	

}
