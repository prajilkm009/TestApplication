package com.example.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="TEST")
@Data
public class User {
	
	
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middeleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="SHIPPING_ADDRESS")
	private String shippingAddress;
	
	@Column(name="BILLING_ADDRESS")
	private String billingAddress;
	
	@PrePersist
	protected void onCreate() {
	   this.setId(UUID.randomUUID().toString());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddeleName() {
		return middeleName;
	}

	public void setMiddeleName(String middeleName) {
		this.middeleName = middeleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	
	
	
	
	
	
	

}
