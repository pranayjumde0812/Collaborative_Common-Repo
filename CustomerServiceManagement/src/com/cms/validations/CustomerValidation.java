package com.cms.validations;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cms.enums.ServicePlan;
import com.cms.exceptions.InvalidCredentials;
import com.cms.exceptions.InvalidPlanException;
import com.cms.tester.Customer;

public class CustomerValidation {
//	public static ServicePlan parseAndValidateAcType(String acType) throws InvalidPlanException {
//		for (ServicePlan color : ServicePlan.values()) {
//			if (color.name().equalsIgnoreCase(acType)) {
//				return ServicePlan.valueOf(acType.toUpperCase());
//
//			}
//		}
//		throw new InvalidPlanException("plan not found");
//	}
	public static ServicePlan parseAndValidateAcType(String acType) throws InvalidPlanException {
	    for (ServicePlan plan : ServicePlan.values()) {
	        if (plan.name().equalsIgnoreCase(acType)) {
	            return plan;
	        }
	    }
	    throw new InvalidPlanException("Plan not found");
	}

	// add a static method for parsing string --> LocalDate
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	public static void checkForDup(String email, ArrayList<Customer> c) throws InvalidCredentials {
		for (Customer a : c) {
			if (a.getEmail().equals(email))
				throw new InvalidCredentials("Email already used");
		}
	}
}
