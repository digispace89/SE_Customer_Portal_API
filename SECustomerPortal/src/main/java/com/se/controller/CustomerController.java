package com.se.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

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
	public Customer createCustomer(@Valid @RequestBody Customer customer){
		
		return customerService.createCustomer(customer);
		
	}
	
	@RequestMapping(value= "/code", method=RequestMethod.PUT)
	public Customer updateCustomerCode(@Valid @RequestBody Customer customer){
		
		return customerService.updateCustomerCode(customer);
		
	}

	@RequestMapping(method=RequestMethod.GET)
	public Customer getCustomerByEmail(@QueryParam(value = "email") String email){

		System.out.println("email:"+email);
		return customerService.getCustomer(email);
	}
	
	@RequestMapping(value="/reset/password" ,method=RequestMethod.PUT)
	public Customer resetPassword(@Valid @RequestBody Customer customer){

		return customerService.resetPassword(customer);
	}
}
