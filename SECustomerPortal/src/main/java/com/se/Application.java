package com.se;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@SpringBootApplication
@ImportResource({"spring-*.xml"})
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
}
