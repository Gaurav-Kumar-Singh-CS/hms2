package com.gaurav.reservationsystem.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservation")
public class Reservation {
	
	@Id
	public String id;
	@Indexed(unique = true)
	public String email;
	public String checkIn;
	public String checkOut;
	public int numberOfAdults;
	public int numberofChildren;
	
	public Reservation() {}
	
	

	public Reservation(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}


	public Reservation(String id, String email, String checkIn, String checkOut, int numberOfAdults, int numberofChildren) {
		super();
		this.id = id;
		this.email = email;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberOfAdults = numberOfAdults;
		this.numberofChildren = numberofChildren;
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

	public int getNumberofChildren() {
		return numberofChildren;
	}

	public void setNumberofChildren(int numberofChildren) {
		this.numberofChildren = numberofChildren;
	}

	
	
	
}
