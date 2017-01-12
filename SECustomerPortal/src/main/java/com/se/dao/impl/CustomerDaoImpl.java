package com.se.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

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
	public void createCustomer(Customer customer) {
		hibernateTemplate.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer mergedCustomer = hibernateTemplate.merge(customer);
		hibernateTemplate.update(mergedCustomer);
	}

	@Override
	public List<Customer> getCustomer(String email) {
		List customers = hibernateTemplate.find("from Customer c where c.email = ?", email);
		return customers;
	}
}
