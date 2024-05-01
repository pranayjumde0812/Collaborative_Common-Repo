package com.cms.utility;

import java.util.ArrayList;

//import com.app.custom_exceptions.CMSException;
import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class SignIn {
	public static String isRegistered(ArrayList<Customer> c,String email,String password) throws InvalidCredentials {
		Customer c1 = new Customer(email);
		if (c.contains(c1) && c.get(c.indexOf(c1)).getPassword().equals(password)) {
			return "already registered";
		}
			throw new InvalidCredentials("Invalid email or password");
	}

	
	public static Customer isEmailPresent(ArrayList<Customer> c,String email)  throws InvalidEmailId{
		Customer c1 = new Customer(email);
			if(c.contains(c1)){
				return c.get(c.indexOf(c1));
			
		}throw new InvalidEmailId("Invalid email");
	}

	public static void changeEmail(ArrayList<Customer> c,String email,String newEmail) throws InvalidEmailId{
		Customer cc = isEmailPresent(c, email);
			cc.setEmail(newEmail);
	}
}
