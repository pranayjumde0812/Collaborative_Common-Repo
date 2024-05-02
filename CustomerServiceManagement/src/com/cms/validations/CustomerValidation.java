package com.cms.validations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import com.cms.enums.ServicePlan;
import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidPlanException;
import com.cms.tester.Customer;

public class CustomerValidation {

	public static ServicePlan parseAndValidateAcType(String acType, double regAmount) throws InvalidPlanException {
		// 1. parse string(plan) -- > enum
		ServicePlan servicePlan = ServicePlan.valueOf(acType.toUpperCase());
		// => plan is valid , now chk if reg amount is correct
		if (servicePlan.getPlanCharges() == regAmount)
			return servicePlan;
		// => incorrect reg amount : throw custom exc
		throw new InvalidPlanException("Reg amount doesn't match with the chose plan cost");

	}

	// add a static method for parsing string --> LocalDate
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	public static void checkForDup(String email, ArrayList<Customer> c) throws InvalidCredentials {
		Customer a = new Customer(email);
		if (c.contains(a))
			throw new InvalidCredentials("Email already used");
	}

	public static void removeAfterGivenDob(String reqDob, ArrayList<Customer> customers) {
		LocalDate requiredDob = LocalDate.parse(reqDob);
		Iterator<Customer> iter = customers.iterator();
		while (iter.hasNext()) {
			Customer cust = iter.next();
			if (cust.getDob().isAfter(requiredDob)) {
				iter.remove();
			}
		}
	}
}
