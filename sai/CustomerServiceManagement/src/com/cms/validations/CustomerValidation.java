package com.cms.validations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import com.cms.enums.ServicePlan;
import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidPlanException;
import com.cms.tester.Customer;

public class CustomerValidation {

	public static void validateAllInputs(String acType, double regAmount,String date,String email, ArrayList<Customer> customers,String password) throws InvalidPlanException, InvalidCredentials {
		parseAndValidateAcType(acType, regAmount);
		parseDate(date);
		validateEmailAndCheckDupli(email, customers);
		validatePassword(password, customers);
	}

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

	public static void validateEmailAndCheckDupli(String email, ArrayList<Customer> customers)
			throws InvalidCredentials {
		String regex = "^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+(com|org|net)$";

		if (!email.matches(regex)) {
			throw new InvalidCredentials("invalid email format");
		}
		Customer customer = new Customer(email);
		if (customers.contains(customer))
			throw new InvalidCredentials("Email already used");
	}

	public static void validatePassword(String password, ArrayList<Customer> c) throws InvalidCredentials {
		String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";

		if (!password.matches(regex)) {
			throw new InvalidCredentials("invalid password format");
		}
	}

//	public static void checkForDup(String email, ArrayList<Customer> customers) throws InvalidCredentials {
//		Customer customer = new Customer(email);
//		if (customers.contains(customer))
//			throw new InvalidCredentials("Email already used");
//	}

	
}
