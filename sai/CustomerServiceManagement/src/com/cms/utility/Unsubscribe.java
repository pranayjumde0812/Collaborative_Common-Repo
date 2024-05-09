package com.cms.utility;

import java.util.ArrayList;

import static com.cms.utility.Utilities.isEmailPresent;
import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class Unsubscribe {
	public static void unSubscribe(ArrayList<Customer> c,String email) throws InvalidEmailId{
		Customer cc = isEmailPresent(c, email);
		c.remove(cc);		
	}
}
