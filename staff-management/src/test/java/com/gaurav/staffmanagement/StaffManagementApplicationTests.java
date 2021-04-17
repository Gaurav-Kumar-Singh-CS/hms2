package com.gaurav.staffmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gaurav.staffmanagement.exception.EmployeeException;
import com.gaurav.staffmanagement.model.Employee;
import com.gaurav.staffmanagement.repository.EmployeeRepo;
import com.gaurav.staffmanagement.service.EmployeeService;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StaffManagementApplicationTests {

	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepo repository;
	
	@Test
	public void findAllEmployeesTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee("a","b","c","d"),new Employee("e","f","g","h")).collect(Collectors.toList()));
		assertEquals(2,service.findAllEmployees().size());
	}
	
	@Test
	public void findEmployeeByIdTest() throws EmployeeException {
		String id = "Hola";
		Employee employee = new Employee("Hola","b","c","d");
		when(repository.findById(id)).thenReturn(Optional.of(employee));
		assertEquals(true,service.findEmployeeById(id).isPresent());
	}
	
	
	@Test
	public void  addEmployeeTest() {
		Employee employee = new Employee("a","b","c","d");
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.addEmployee(employee));
	}
	
	@Test
	public void deleteEmployeeTest() {
		@SuppressWarnings("unused")
		Employee employee = new Employee("a","b","c","d");
		service.deleteEmployee("a");
		verify(repository, times(1)).deleteById("a");
		
	}

}
