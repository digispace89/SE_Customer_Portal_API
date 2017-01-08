package com.se.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_TYPE")
public class CustomerType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="type")
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CustomerType [id=" + id + ", type=" + type + "]";
	}

	public CustomerType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerType(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	
}
