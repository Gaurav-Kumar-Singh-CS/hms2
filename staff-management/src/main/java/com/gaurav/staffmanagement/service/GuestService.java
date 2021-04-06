package com.gaurav.staffmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.staffmanagement.model.Guest;
import com.gaurav.staffmanagement.repository.EmployeeRepo;

@Service
public class GuestService {
	private final EmployeeRepo employeeRepo;

	@Autowired
	public GuestService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public Guest addEmployee(Guest employee) {
		employee.setEmployeeCode("asdsedfgst");
		return employeeRepo.save(employee);
	}
	
	public List<Guest> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Guest updateEmployee(Guest employee) {
		return employeeRepo.save(employee);
	}
	
	public Optional<Guest> findEmployeeById(String id) {
		Optional<Guest> employeeById = employeeRepo.findById(id);
		return employeeById;
	}
	
	public void deleteEmployee(String id) {
		employeeRepo.deleteById(id);
	}
}
