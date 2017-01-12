package com.se.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.se.dao.CustomerDao;
import com.se.model.Customer;
import com.se.model.CustomerType;
import com.se.util.EmailUtil;
import com.se.util.PasswordUtil;

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
		customerDao.createCustomer(customer);
		return customer;
	}

	@Override
	public Customer getCustomer(String email) {
		List customers = customerDao.getCustomer(email);
		if(customers.size()>0)
			return (Customer) customers.get(0) ;
		else 
			return null;
	}

	@Override
	@Transactional
	public Customer updateCustomerCode(String customerCode,String email) {
		Customer customer = getCustomer(email);
		customer.setCustomerCode(customerCode);
		customer.setPassword(PasswordUtil.generatePassword());
		customerDao.updateCustomer(customer);
		EmailUtil.sendEmail(email, customer.getPassword());
		return customer;
	}

	@Override
	@Transactional
	public Customer resetPassword(String email, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
