package come.se.service;

import java.util.List;

import com.se.model.Customer;
import com.se.model.CustomerType;

public interface CustomerService {

	List<CustomerType> getAllCustomerTypes();
	Customer createCustomer(Customer customer);
	Customer getCustomer(String email);
	Customer updateCustomerCode(String customerCode, String email);
	Customer resetPassword(String email, String oldPassword, String newPassword);

}
