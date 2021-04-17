package com.gaurav.staffmanagement.model;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "staff")
public class Employee{
	
	@Id
	private String id;
	private String name;
	
	@NotNull(message = "Email cannot be null!")
	private String email;
	private String jobTitle;
	private String phone;
	private Address address;
	private int salary;
	public Employee() {}
	
	
	public Employee(String id, String name, String email, String jobTitle, String phone, Address address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.address = address;
		this.salary = salary;
	}

	public Employee(String id, String email, String jobTitle, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
