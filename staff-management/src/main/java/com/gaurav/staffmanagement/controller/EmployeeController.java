package com.gaurav.staffmanagement.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gaurav.staffmanagement.exception.EmployeeException;
import com.gaurav.staffmanagement.model.Employee;
import com.gaurav.staffmanagement.service.EmployeeService;

@RestController
@RequestMapping("/staff")
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.findAllEmployees();
		try {
			if(employees.size() > 0) {
				return new ResponseEntity<>(employees, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} 
		catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") String id) throws EmployeeException{
		try {
			Optional<Employee> employee = employeeService.findEmployeeById(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
		catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}

	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		try {
			Employee newEmployee = employeeService.addEmployee(employee);
			return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id){
		try {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
