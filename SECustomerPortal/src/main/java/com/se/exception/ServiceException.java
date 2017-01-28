package com.se.exception;

import java.util.List;

@SuppressWarnings("serial")
public class ServiceException extends BaseException{

	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(String message, List<Error> errors) {
		super(message);
		super.errors = errors;
	}

}
