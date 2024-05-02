package com.cms.utility;

import java.util.ArrayList;

import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class Utilities {
	public static Customer isEmailPresent(ArrayList<Customer> c,String email)  throws InvalidEmailId{
		Customer c1 = new Customer(email);
			if(c.contains(c1)){
				return c.get(c.indexOf(c1));
			
		}throw new InvalidEmailId("Invalid email");
	}

	public static void changePassword(ArrayList<Customer> c,String email,String newPassword) throws InvalidEmailId{
		Customer cc = isEmailPresent(c, email);
			cc.setPassword(newPassword);
	}
}
