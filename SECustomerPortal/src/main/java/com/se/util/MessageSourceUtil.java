package com.se.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceUtil {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getProperty(String property, String... params){
		return messageSource.getMessage(property,params, LocaleContextHolder.getLocale());
	}
	
}
