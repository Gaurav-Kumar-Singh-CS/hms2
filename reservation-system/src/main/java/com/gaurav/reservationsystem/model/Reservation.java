package com.gaurav.reservationsystem.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection = "reservation")
public class Reservation {
	
	@Id
	public String id;
	@Indexed(unique = true)
	public String email;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	public String checkIn;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	public String checkOut;
	public int numberOfAdults;
	public int numberOfChildren;
	@Indexed(unique = true)
	public String roomType;
	public float totalCost;
	
	public Reservation() {}
	
	

	public Reservation(String id, String email, String roomType) {
		super();
		this.id = id;
		this.email = email;
		this.roomType = roomType;
	}
	


	public Reservation(String id, String email, String checkIn, String checkOut, int numberOfAdults,
			int numberOfChildren, String roomType, float totalCost) {
		super();
		this.id = id;
		this.email = email;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
		this.roomType = roomType;
		this.totalCost = totalCost;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCheckIn() {
		return checkIn;
	}



	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}



	public String getCheckOut() {
		return checkOut;
	}



	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}



	public int getNumberOfAdults() {
		return numberOfAdults;
	}



	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}



	public int getNumberOfChildren() {
		return numberOfChildren;
	}



	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}



	public String getRoomType() {
		return roomType;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	

	public float getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	
	
	
}
