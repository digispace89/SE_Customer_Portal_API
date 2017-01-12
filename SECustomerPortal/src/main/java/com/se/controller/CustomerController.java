package com.se.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.se.model.Customer;
import com.se.model.CustomerType;

import come.se.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/types" , method=RequestMethod.GET)
	public List<CustomerType> getAllCustomerTypes(){
		
		return customerService.getAllCustomerTypes();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer){
		
		return customerService.createCustomer(customer);
		
	}
	
	@RequestMapping(value= "/email/{email}/code/{code}", method=RequestMethod.PUT)
	public Customer updateCustomerCode(@PathVariable String email, @PathVariable String code){
		
		return customerService.updateCustomerCode(code,email);
		
	}
	
	@RequestMapping(value="/email/{email:.+}" ,method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable String email){

		System.out.println("email:"+email);
		return customerService.getCustomer(email);
	}
	
	@RequestMapping(value="/email/{email:.+}" ,method=RequestMethod.PUT)
	public Customer resetPassword(@PathVariable String email,@RequestBody String password){

		System.out.println("email:"+email);
		return customerService.getCustomer(email);
	}
}
