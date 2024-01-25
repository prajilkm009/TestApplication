package com.example.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USER_TAB")
@Data
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	   this.id=UUID.randomUUID().toString();
	}
	

}
