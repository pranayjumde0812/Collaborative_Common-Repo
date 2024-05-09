package com.cms.utility;

import java.util.List;

import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class SignIn {
	public static String isRegistered(List<Customer> customers, String email, String password)
			throws InvalidCredentials, InvalidEmailId {
		Customer newCustomer = new Customer(email);
		int index = customers.indexOf(newCustomer);
		if (index == -1) {
			throw new InvalidEmailId("Invalid email");
		}
		if (customers.get(index).getPassword().equals(password)) {
			return "Login successful";
		}
		throw new InvalidCredentials("Invalid email or password");
	}
}
