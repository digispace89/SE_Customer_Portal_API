package com.se.exception;

import java.util.List;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException{

	protected List<Error> errors;
	
	public BaseException(String message,List<Error> errors, Throwable cause){
		super(message,cause);
		this.errors = errors;
	}
	
	public BaseException(String message, List<Error> errors){
		super(message);
		this.errors = errors;
	}
	
	public BaseException(String message, Throwable cause){
		super(message,cause);
	}
	
	public BaseException(String message){
		super(message);
	}
	
	public List<Error> getErrors(){
		return errors;
	}
	
}
