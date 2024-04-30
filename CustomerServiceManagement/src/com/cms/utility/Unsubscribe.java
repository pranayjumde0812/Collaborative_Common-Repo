package com.cms.utility;

import java.util.ArrayList;
import static com.cms.utility.SignIn.*;

import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class Unsubscribe {
	public static void unSubscribe(ArrayList<Customer> c,String email,String password) throws InvalidEmailId,InvalidCredentials {
		Customer cc = isEmailPresent(c, email);
		if(password.equals(cc.getPassword())) {
			c.remove(cc);
		}
		else{
			throw new InvalidCredentials("incorrect password");
		};
		
	}
}
