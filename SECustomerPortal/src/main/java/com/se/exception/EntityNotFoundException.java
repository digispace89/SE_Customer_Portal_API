package com.se.exception;

import java.util.List;

@SuppressWarnings("serial")
public class EntityNotFoundException extends BaseException{

	public EntityNotFoundException(String message) {
		super(message);
	}

}
