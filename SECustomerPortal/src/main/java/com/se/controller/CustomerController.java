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
	
	@RequestMapping(value= "/{email}/code/{code}", method=RequestMethod.PUT)
	public Customer updateCustomerCode(@PathVariable String email, @PathVariable String code){
		
		return customerService.getCustomer(email);
		
	}
	
	@RequestMapping(value="/email/{email}" ,method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable String email){
		/*Customer customer = new Customer("user@gmail.com","Hopital01",
				"7262829282","contactname01",new CustomerType(1L,"Hospital"),"301112266789","16722",null,"2827822",null,null,"p@ssw0rd");
		customer.setId(id);
		return customer;*/
		System.out.println(email);
		return customerService.getCustomer(email);
	}
}
