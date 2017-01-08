package com.se.dao;

import java.util.List;

import com.se.model.Customer;
import com.se.model.CustomerType;

public interface CustomerDao {

	List<CustomerType> getAllCustomerTypes();
	Customer createCustomer(Customer customer);
	Customer updateCustomerCode(String customerCode);
	Customer getCustomer(String email);

}
