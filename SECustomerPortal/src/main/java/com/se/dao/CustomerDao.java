package com.se.dao;

import java.util.List;

import com.se.model.Customer;
import com.se.model.CustomerType;

public interface CustomerDao {

	List<CustomerType> getAllCustomerTypes();
	void createCustomer(Customer customer);
	void updateCustomer(Customer customer);
	List<Customer> getCustomer(String email);
	CustomerType getCustomerType(Long id);


}
