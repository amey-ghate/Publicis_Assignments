package com.amey.mockito.exceptions;

public class ServiceException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super("There was some validation issues");
	}

}