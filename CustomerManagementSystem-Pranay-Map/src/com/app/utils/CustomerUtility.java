package com.app.utils;

import static com.app.validations.CustomerValidation.validAllInputs;
import static com.app.validations.CustomerValidation.validatePassword;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.cms.Customer;
import com.app.custom_exception.DuplicateCustomerException;
import com.app.custom_exception.InvalidCredentialsException;
import com.app.custom_exception.NotAlphanumericPasswordException;
import com.app.custom_exception.NotEmailFormatException;
import com.app.custom_exception.ServicePlanDetailsMisMatchedException;
import com.app.custom_exception.ServicePlanNotFoundException;
import com.app.enums.ServicePlan;

public class CustomerUtility {

	public static Map<String, Customer> acceptCustomerDetails(Map<String, Customer> list)
			throws IllegalArgumentException, DuplicateCustomerException, ServicePlanDetailsMisMatchedException,
			ServicePlanNotFoundException, NotEmailFormatException, NotAlphanumericPasswordException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First name : ");
		String firstName = scanner.next();
		System.out.println("Enter Last name : ");
		String lastName = scanner.next();
		System.out.println("Enter email : ");
		String email = scanner.next();
		System.out.println("Enter Password : ");
		String pass = scanner.next();
		System.out.println("Enter Date of Birth :- yyyy-MM-dd ");
		String dob = scanner.next();
		System.out.println("Enter service plan");
		String servicePlan = scanner.next();
		System.out.println("Enter Registration amount : ");
		double registrationAmount = scanner.nextDouble();

		Customer customer = validAllInputs(firstName, lastName, email, pass, registrationAmount, dob, servicePlan,
				list);
		list.put(email, customer);

		return list;
	}

//    public static Customer checkRegisteredCustomer(List<Customer> list, String email) throws InvalidCredentialsException {
//
////        for (Customer customer : list) {
////            if (customer != null && email.equals(customer.getEmail())) {
////                return customer;
////            }
////        }
//
//        Customer customer = new Customer(email);
//        if (list.contains(customer)) {
//            return list.get(list.indexOf(customer));
//        }
//        throw new InvalidCredentialsException("Email not registered");
//    }

	public static Customer loginTOAccount(Map<String, Customer> list, String email, String password)
			throws InvalidCredentialsException {
//        Customer customer = checkRegisteredCustomer(list, email);
//        if (customer.getPassword().equals(password)) {
//            return customer;
//        }                                                  // this logic will increase time complexity
//        throw new InvalidCredentialsException("Invalid Credentials");

		// this is fast performance logic
//        Customer newCustomer = new Customer(email);
//        int index = ; // TC: O(n)
		if (!list.containsKey(email)) {
			throw new InvalidCredentialsException("Email not registered");
		} else {
			Customer validCustomer = list.get(email); // TC: O(1)
			if (validCustomer != null) {
				return validCustomer;
			} else
				throw new InvalidCredentialsException("Invalid Credentials");
		}

	}

	public static String customerUnsubscribe(Map<String, Customer> list, String email)
			throws InvalidCredentialsException {
//        Customer customer = checkRegisteredCustomer(list, email);
//        list.remove(list.indexOf(customer));
		Customer foundCustomer;
//		Customer customer = new Customer(email);
//		int index = ; // TC: O(n)
		if (!list.containsKey(email)) {
			throw new InvalidCredentialsException("Not a registered customer");
		} else {
			foundCustomer = list.get(email); // TC: O(1)
			list.remove(email);
		}
		return "Customer " + foundCustomer.getFirstName() + " is unsubscribed";
	}

	public static void updatePassword(Map<String, Customer> list, String email, String oldPassword, String newPassword)
			throws InvalidCredentialsException, NotAlphanumericPasswordException {
		Customer customer = loginTOAccount(list, email, oldPassword);
		if (customer.getPassword().equals(oldPassword)) {
			newPassword = validatePassword(newPassword);
			customer.setPassword(newPassword);
			System.out.println("Password Updated Successfully");
		} else
			throw new InvalidCredentialsException("Invalid Credentials");
	}

	public static void displayAllCustomersDetails(Map<String, Customer> customers) {
		for (Customer customer : customers.values()) {
			System.out.println(customer);
		}
	}

	public static void removeCustomerAfterGivenDob(Map<String, Customer> customerList, String date) {
		LocalDate givenDate = LocalDate.parse(date);
		
		Collection<Customer> c = customerList.values();
		List<Customer> list = new ArrayList<Customer>(c);
//		List<Customer> list2 = new LinkedList<Customer>(c); 
//
//		list.addAll(c);
//		list2.addA

		Iterator<Customer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			if (customer.getDateOfBirth().isAfter(givenDate)) {
//				iterator.remove();
				customerList.remove(customer.getEmail());
			}
		}

	}

	public static Map<String, Customer> populatedData() {
		Customer c1 = new Customer("Pranay", "Jumde", "p@gmail.com", "123", 2000, LocalDate.parse("1999-08-08"),
				ServicePlan.valueOf("GOLD"));
		Customer c2 = new Customer("Ayush", "Gupta", "a@gmail.com", "123", 2000, LocalDate.parse("1999-08-08"),
				ServicePlan.valueOf("GOLD"));
		Customer c3 = new Customer("Karshin", "Sinha", "k@gmail.com", "123", 2000, LocalDate.parse("2001-11-12"),
				ServicePlan.valueOf("GOLD"));
		Customer c4 = new Customer("Sai", "Kakde", "s@gmail.com", "123", 2000, LocalDate.parse("2001-11-12"),
				ServicePlan.valueOf("GOLD"));
		Customer c5 = new Customer("Prajwal", "Wandhare", "pw@gmail.com", "123", 2000, LocalDate.parse("2000-02-02"),
				ServicePlan.valueOf("GOLD"));

		Map<String, Customer> customerList = new HashMap<String, Customer>();
		customerList.put(c1.getEmail(), c1);
		customerList.put(c2.getEmail(), c2);
		customerList.put(c3.getEmail(), c3);
		customerList.put(c4.getEmail(), c4);
		customerList.put(c5.getEmail(), c5);

		return customerList;
	}
}
