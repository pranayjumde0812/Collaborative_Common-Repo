package com.cms.utility;

import java.util.Comparator;

import com.cms.tester.Customer;

public class CustomerDateAndLastNameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		int res = o1.getDob().compareTo(o2.getDob());

		if (res == 0) {
			return o1.getLastName().compareTo(o2.getLastName());
		}
		return 1;
	}
}
