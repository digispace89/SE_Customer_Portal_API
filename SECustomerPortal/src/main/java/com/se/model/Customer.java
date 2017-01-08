package com.se.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="CUSTOMER")
@NamedQueries({@NamedQuery(name="GetCustomerByEmail" , query="select c from Customer c where email=:email")})
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="contact_name")
	private String contactName;
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=CustomerType.class)
	@JoinColumn(name="customer_type_id", referencedColumnName="id")
	private CustomerType customerType;
	
	@Column(name="tin_number")
	private String tinNumber;
	
	@Column(name="drug_license_number")
	private String drugLicenseNumber;
	
	@Column(name="pan_number")
	private String panNumber;
	
	@Column(name="gst_number")
	private String gstNumber;
	
	@Column(name="registration_number")
	private String registrationNumber;
	
	@Column(name="customer_code")
	private String customerCode;
	
	@Column(name="password")
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public String getTinNumber() {
		return tinNumber;
	}
	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}
	public String getDrugLicenseNumber() {
		return drugLicenseNumber;
	}
	public void setDrugLicenseNumber(String drugLicenseNumber) {
		this.drugLicenseNumber = drugLicenseNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer( String email, String name, String contactNumber, String contactName,
			CustomerType customerType, String tinNumber, String drugLicenseNumber, String panNumber, String gstNumber,
			String registrationNumber, String customerCode, String password) {
		super();
		this.email = email;
		this.name = name;
		this.contactNumber = contactNumber;
		this.contactName = contactName;
		this.customerType = customerType;
		this.tinNumber = tinNumber;
		this.drugLicenseNumber = drugLicenseNumber;
		this.panNumber = panNumber;
		this.gstNumber = gstNumber;
		this.registrationNumber = registrationNumber;
		this.customerCode = customerCode;
		this.password = password;
	}
	
	
	
}
