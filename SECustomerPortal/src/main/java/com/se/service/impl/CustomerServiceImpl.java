package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.CustomerDao;
import com.se.model.Customer;
import com.se.model.CustomerType;

import come.se.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<CustomerType> getAllCustomerTypes() {
		return customerDao.getAllCustomerTypes();
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		customer.setPassword("Password");
		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer getCustomer(String email) {
		return customerDao.getCustomer(email);
	}

	@Override
	public Customer updateCustomerCode(String customerCode) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
