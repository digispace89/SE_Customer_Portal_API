package com.se.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.DataBinder;

import com.se.dao.CustomerDao;
import com.se.exception.DaoException;
import com.se.exception.EntityNotFoundException;
import com.se.exception.ServiceException;
import com.se.model.Customer;
import com.se.model.CustomerType;
import com.se.util.EmailUtil;
import com.se.util.PasswordUtil;
import com.se.validator.CustomerValidator;

import come.se.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private CustomerValidator customerValidator;
	
	@Override
	public List<CustomerType> getAllCustomerTypes() {
		return customerDao.getAllCustomerTypes();
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		DataBinder binder = new DataBinder(customer);
		binder.setValidator(customerValidator);
		binder.validate();
		
		try {
			customerDao.createCustomer(customer);
		} catch(Exception ex){
			if(ex instanceof DataAccessException || ex instanceof HibernateException){
				throw new DaoException(ex.getMessage());	
			}else{
				throw new ServiceException(ex.getMessage());
			}	
		}
		return customer;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Customer getCustomer(String email) {
		List customers = customerDao.getCustomer(email);
		if (customers.size() > 0)
			return (Customer) customers.get(0);
		else
			throw new EntityNotFoundException("Customer not found with email" + email);
	}

	@Override
	@Transactional
	public Customer updateCustomerCode(Customer customer) {
		Customer persistentCustomer = getCustomer(customer.getEmail());
		
		persistentCustomer.setCustomerCode(customer.getCustomerCode());
		try{
			persistentCustomer.setPassword(PasswordUtil.generatePassword());
			customerDao.updateCustomer(persistentCustomer);
			emailUtil.sendEmail(customer.getEmail(), customer.getPassword());

		}catch(Exception ex){
			if(ex instanceof DataAccessException || ex instanceof HibernateException){
				throw new DaoException(ex.getMessage());	
			}else{
				throw new ServiceException(ex.getMessage());
			}	
		}
		return persistentCustomer;

	}

	@Override
	@Transactional
	public Customer resetPassword(Customer customer) {
		Customer persistentCustomer = getCustomer(customer.getEmail());
		try{

		persistentCustomer.setPassword(PasswordUtil.generatePassword());
		customerDao.updateCustomer(persistentCustomer);
		emailUtil.sendEmail(customer.getEmail(), customer.getPassword());
		}catch(Exception ex){
			if(ex instanceof DataAccessException || ex instanceof HibernateException){
				throw new DaoException(ex.getMessage());	
			}else{
				throw new ServiceException(ex.getMessage());
			}	
		}
		return persistentCustomer;
	}

}
