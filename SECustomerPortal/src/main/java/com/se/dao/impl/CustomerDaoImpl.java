package com.se.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jayway.jsonpath.Criteria;
import com.se.dao.CustomerDao;
import com.se.model.Customer;
import com.se.model.CustomerType;


@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<CustomerType> getAllCustomerTypes() {
		
		return hibernateTemplate.loadAll(CustomerType.class);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		hibernateTemplate.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomerCode(String customerCode) {
		return null;
	}

	@Override
	public Customer getCustomer(String email) {
		List customers = hibernateTemplate.findByNamedQueryAndNamedParam("GetCustomerByEmail","email",email);
		return (Customer) customers.get(0);

	}}
