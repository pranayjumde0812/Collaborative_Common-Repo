package com.cms.utility;

import java.util.ArrayList;

import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class Utilities {
	public static Customer isEmailPresent(ArrayList<Customer> customers,String email)  throws InvalidEmailId{
		Customer customer1 = new Customer(email);
			if(customers.contains(customer1)){
				return customers.get(customers.indexOf(customer1));
			
		}throw new InvalidEmailId("Invalid email");
	}

	public static void changePassword(ArrayList<Customer> customers,String email,String newPassword) throws InvalidEmailId{
		Customer customer2 = isEmailPresent(customers, email);
		customer2.setPassword(newPassword);
	}
	public static void sortCustomersByEmail(String next, ArrayList<Customer> customers) {
		// TODO Auto-generated method stub
		
	}
}
