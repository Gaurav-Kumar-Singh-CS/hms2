package com.gaurav.staffmanagement.exception;

public class RecordAlreadyPresent extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordAlreadyPresent(String s) {
	super(s);
	}

}
