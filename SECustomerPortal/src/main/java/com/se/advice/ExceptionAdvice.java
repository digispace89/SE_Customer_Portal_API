package com.se.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.se.exception.EntityNotFoundException;
import com.se.exception.ServiceException;

@EnableWebMvc
@ControllerAdvice
public class ExceptionAdvice {
	
		@ResponseBody
		@ExceptionHandler(EntityNotFoundException.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		Exception entityNotFoundExceptionHandler(EntityNotFoundException ex){
			System.out.println("e:"+ex.getMessage());
			return ex;
		}
		
		@ResponseBody
		@ExceptionHandler(ServiceException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		Exception serviceExceptionHandler(ServiceException ex){
			System.out.println("e:"+ex.getMessage());
			return ex;
		}
		
		@ResponseBody
		@ExceptionHandler
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		Exception genericExceptionHandler(Exception ex){
			System.out.println("e:"+ex.getMessage());
			return ex;
		}

}
