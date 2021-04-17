package com.gaurav.staffmanagement.exception;

public class EmployeeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Employee with this Id doesn't exist";
	}
	
	public static String EmployeeAlreadyExists() {
		return "Employee already exists!";
	}

}
