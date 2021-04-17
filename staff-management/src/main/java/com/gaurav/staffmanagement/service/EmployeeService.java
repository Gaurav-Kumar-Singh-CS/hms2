package com.gaurav.staffmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.staffmanagement.exception.EmployeeException;
import com.gaurav.staffmanagement.exception.RecordNotFoundException;
import com.gaurav.staffmanagement.model.Employee;
import com.gaurav.staffmanagement.repository.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	
	/*public Employee addEmployee(Employee employee) {
		Optional<Employee> findEmployeeById = findEmployeeById(employee.getId());
			if (!findEmployeeById.isPresent()) {
				return employeeRepo.save(employee);
			} else
				throw new RecordAlreadyPresent(
						"User with Id: " + employee.getId() + " already exists!!");
		}*/
	
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Optional<Employee> findEmployeeById(String id) throws EmployeeException {
		Optional<Employee> employeeById = employeeRepo.findById(id);
		if(employeeById.isPresent()) {
			return employeeById;
		}else {
			throw new EmployeeException(EmployeeException.NotFoundException(id));
		}
		
	}
	
	public void deleteEmployee(String id) throws RecordNotFoundException {
		if(id == null) {
			throw new RecordNotFoundException("Enter valid Id");
		}
		employeeRepo.deleteById(id);
	}



}
