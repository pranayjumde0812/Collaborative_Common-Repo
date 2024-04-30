package com.cms.utility;

import java.util.ArrayList;

import com.cms.exceptions.InvalidCredentials;
import com.cms.tester.Customer;

public class SignIn {
//	public static String signIn(ArrayList<Customer> c,String email,String password) {
//		isRegistered(c, email);
//		return null;
//	}
	public static String isRegistered(ArrayList<Customer> c,String email,String password) throws InvalidCredentials {
		for(Customer cc:c) {
			if(email.equals(cc.getEmail()) && password.equals(cc.getPassword())) {
				return "Login Successful";
			}
		}throw new InvalidCredentials("Invalid email or password");
//		return null;
	}
	
}
