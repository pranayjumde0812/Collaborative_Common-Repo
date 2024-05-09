package com.cms.utility;
import static com.cms.validations.CustomerValidation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import com.cms.enums.ServicePlan;
import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidEmailId;
import com.cms.tester.Customer;

public class Utilities {
	public static Customer isEmailPresent(ArrayList<Customer> customers,String email)  throws InvalidEmailId{
		Customer customer1 = new Customer(email);
			if(customers.contains(customer1)){
				return customers.get(customers.indexOf(customer1));
			
		}throw new InvalidEmailId("Invalid email");
	}

	public static void changePassword(ArrayList<Customer> customers,String email,String newPassword) throws InvalidEmailId, InvalidCredentials{
		Customer customer2 = isEmailPresent(customers, email);
		validatePassword(newPassword, customers);
		customer2.setPassword(newPassword);
	}
	public static void removeAfterGivenDobAndPlan(String reqDob, String plan, ArrayList<Customer> customers) {
		LocalDate requiredDob = LocalDate.parse(reqDob);
		ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
		Iterator<Customer> iter = customers.iterator();
		while (iter.hasNext()) {
			Customer cust = iter.next();
			if (cust.getDob().isAfter(requiredDob) && cust.getPlan() == servicePlan) {
				iter.remove();
			}
		}
	}
}
