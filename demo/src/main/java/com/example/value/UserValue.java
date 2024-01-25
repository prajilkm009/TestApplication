package com.example.value;

import lombok.Data;

@Data
public class UserValue {
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
	private BillingAddress billingAddres;
	
	private ShippingAddress shippingAddress;
	
	

}
