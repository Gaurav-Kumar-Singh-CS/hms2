package com.gaurav.staffmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.staffmanagement.model.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String>{
	
	

}
