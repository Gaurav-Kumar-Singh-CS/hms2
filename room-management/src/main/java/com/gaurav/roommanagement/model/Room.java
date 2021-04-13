package com.gaurav.roommanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "room")
public class Room {
	
	@Id
	public String id;
	@Indexed(unique = true)
	public String roomType;
	public int cost;
	public int totalRooms;
	
	public Room() {}

	public Room(String id, String roomType, int cost, int totalRooms) {
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	
	

}
