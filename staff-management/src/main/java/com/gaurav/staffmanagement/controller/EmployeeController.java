package com.gaurav.staffmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaurav.staffmanagement.model.Guest;
import com.gaurav.staffmanagement.service.GuestService;

@RestController
@RequestMapping("/staff")
public class EmployeeController {
	private final GuestService employeeService;

	public EmployeeController(GuestService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Guest>> getAllEmployees(){
		List<Guest> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Guest>> getEmployeeById(@PathVariable("id") String id){
		Optional<Guest> employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	
	@PostMapping("/add")
	public ResponseEntity<Guest> addEmployee(@RequestBody Guest employee){
		Guest newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Guest> updateEmployee(@RequestBody Guest employee){
		Guest updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
