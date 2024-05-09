package com.cms.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.cms.enums.ServicePlan;
import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidPlanException;
import com.cms.tester.Customer;
import static com.cms.validations.CustomerValidation.*;

public class SignUp {
//	String firstName, String lastName, String email, String password, double registrationAmount,
//	LocalDate dob, ServicePlan plan
	public static Customer signUp(ArrayList<Customer> customers,Scanner sc) throws InvalidCredentials, InvalidPlanException {
		
        customers.add(new Customer("John", "Doe", "john@example.com", "john@123", 2000.0, LocalDate.of(1990, 5, 15), ServicePlan.GOLD));
        customers.add(new Customer("Jane", "Smith", "jane@example.com", "jane@123", 1000.0, LocalDate.of(1985, 10, 20), ServicePlan.SILVER));
        customers.add(new Customer("Alice", "Johnson", "alice@example.com", "alice@123", 1000.0, LocalDate.of(1995, 3, 8), ServicePlan.PLATINUM));

		
		System.out.println("enter the first name");
		String firstname = sc.next();
		System.out.println("enter the last name");
		String lastname = sc.next();
		System.out.println("enter the email");
		String email = sc.next();
		validateEmailAndCheckDupli(email, customers);
		System.out.println("enter the password");
		String password = sc.next();
		validatePassword(password, customers);
		System.out.println("enter the dob yyyy-MM-dd");
		String dob = sc.next();
		LocalDate dob1 = LocalDate.parse(dob);
		System.out.println("enter the plan");
		String plan = sc.next();
		System.out.println("enter the registrationAmount");
		double registrationAmount = sc.nextDouble();
		ServicePlan servicePlan= parseAndValidateAcType(plan,registrationAmount);
		
		

		Customer customer = new Customer(firstname, lastname, email, password, registrationAmount, dob1,
				servicePlan);
		System.out.println(customer);
		customers.add(customer);
		return customer;
	

	}
}
