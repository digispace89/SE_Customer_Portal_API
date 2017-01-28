package com.se.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.se.dao.CustomerDao;
import com.se.model.Customer;
import com.se.model.CustomerType;

@Component
public class CustomerValidator implements Validator {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Customer.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Customer customer = (Customer) object;
		
		ValidationUtils.rejectIfEmpty(errors, "email", "customer.email.required");
		ValidationUtils.rejectIfEmpty(errors, "contactName", "customer.contactNumber.required");
		ValidationUtils.rejectIfEmpty(errors, "contactNumber", "customer.contactNumber.required");
		ValidationUtils.rejectIfEmpty(errors, "customerType", "customer.type.required");
		ValidationUtils.rejectIfEmpty(errors, "customerType.id", "customer.type.id.required");
		CustomerType customerType = customer.getCustomerType();
		
		if(null!= customerType && null!= customerType.getId()){
			if(isValidCustomerType(customerType.getId())){
				//hospital
				if(customerType.getId() == 1){
					ValidationUtils.rejectIfEmpty(errors, "name", "customer.name.required");
					ValidationUtils.rejectIfEmpty(errors, "tinNumber", "customer.tinNumber.required");
					ValidationUtils.rejectIfEmpty(errors, "drugLicenseNumber", "customer.drugLicenseNumber.required");
					//pharmacy
				}else if(customerType.getId() == 2){
					ValidationUtils.rejectIfEmpty(errors, "name", "customer.name.required");
					ValidationUtils.rejectIfEmpty(errors, "tinNumber", "customer.tinNumber.required");
					ValidationUtils.rejectIfEmpty(errors, "drugLicenseNumber", "customer.drugLicenseNumber.required");
					//doctor
				}else if(customerType.getId() == 3){
					ValidationUtils.rejectIfEmpty(errors, "registrationNumber", "customer.registrationNumber.required");
					ValidationUtils.rejectIfEmpty(errors, "panNumber", "customer.panNumber.required");
				}
		}else{
			errors.reject("customer.type.invalid");
		}
			
		}
	}

	public boolean isValidCustomerType(Long id){
		CustomerType customerType = customerDao.getCustomerType(id);
		if( null == customerType )
			return false;
		else
			return true;
		
	}
}
