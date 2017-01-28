package com.se.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.se.model.Error;


@EnableWebMvc
@ControllerAdvice
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public Object beforeBodyWrite(Object responseObj, MethodParameter methodParameter, MediaType mediaType,
			Class<? extends HttpMessageConverter<?>> hmc, ServerHttpRequest serverRequest,
			ServerHttpResponse servletResponse) {
		ServletServerHttpResponse response = (ServletServerHttpResponse) servletResponse;
		HttpHeaders responseHeaders = response.getHeaders();
		responseHeaders.add(HttpHeaders.PRAGMA, "no-cache");
		responseHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		if(response.getServletResponse().getStatus()==HttpStatus.OK.value()){
			if(serverRequest.getMethod() == HttpMethod.POST){
				servletResponse.setStatusCode(HttpStatus.CREATED);
			}else if(serverRequest.getMethod() == HttpMethod.DELETE){
				servletResponse.setStatusCode(HttpStatus.NO_CONTENT);
			}
		}
		
		int statusCode = response.getServletResponse().getStatus();
/*		if(statusCode<400){
			return responseObj;
		}else */
		if(responseObj instanceof Exception){
			Exception e = (Exception) responseObj;
			Error error = new Error();
			error.setErrorCode(e.getClass().getSimpleName());
			error.setErrorMessage(e.getMessage());
			return error;
		}
		
		return responseObj;
	}

	@Override
	public boolean supports(MethodParameter paramMethodParameter, Class<? extends HttpMessageConverter<?>> paramClass) {
		return true;
	}
	


}
