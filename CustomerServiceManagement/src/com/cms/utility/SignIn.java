package com.cms.utility;

import java.util.ArrayList;

import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class SignIn {
	public static String isRegistered(ArrayList<Customer> c,String email,String password) throws InvalidCredentials {
		for(Customer cc:c) {
			if(email.equals(cc.getEmail()) && password.equals(cc.getPassword())) {
				return "Login Successful";
			}
		}throw new InvalidCredentials("Invalid email or password");
	}
	
	public static Customer isEmailPresent(ArrayList<Customer> c,String email)  throws InvalidEmailId{
		for(Customer cc:c) {
			if(email.equals(cc.getEmail())){
				return cc;
			}
		}throw new InvalidEmailId("Invalid email");
	}

	public static void changeEmail(ArrayList<Customer> c,String email,String newEmail) throws InvalidEmailId{
		Customer cc = isEmailPresent(c, email);
			cc.setEmail(newEmail);
	}
}
