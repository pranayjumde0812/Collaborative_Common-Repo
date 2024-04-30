package com.app.utils;

import com.app.banking.BankAccount;
import com.app.custom_exceptions.BankingException;

public class BankingUtils {
//add a static method to return a/c details or throw exc
	public static BankAccount findAccountDetailsByAcctNo(int accNo, BankAccount[] accts) throws BankingException {
//1. create bank a/c instance wrapping PK (acct no)
		BankAccount acct = new BankAccount(accNo);
		//2. attach for-each loop to invoke equals --acct no based equality
		for (BankAccount a : accts) {
			if (a != null && a.equals(acct))
				return a;
		}
		throw new BankingException("Invalid a/c no !!!!!");
	}
}
