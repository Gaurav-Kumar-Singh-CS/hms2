package com.gaurav.guestmanagement.model;

public class Address {
	public String city;
	public String state;
	public String pin;
	
	public Address() {}
	
	public Address(String city, String state, String pin) {
		super();
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
	
	
}
