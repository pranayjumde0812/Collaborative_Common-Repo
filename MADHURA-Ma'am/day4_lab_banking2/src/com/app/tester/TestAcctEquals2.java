package com.app.tester;

import java.time.LocalDate;

import com.app.banking.AcType;
import com.app.banking.BankAccount;

public class TestAcctEquals2 {

	public static void main(String[] args) {
		Object a1 = new BankAccount(101, "a1", "b1", AcType.SAVINGS, LocalDate.parse("1990-12-17"),
				LocalDate.parse("2011-12-17"), 15000);//up casting
		Object a2 = new BankAccount(101, "a1", "b1", AcType.SAVINGS, LocalDate.parse("1990-12-17"),
				LocalDate.parse("2011-12-17"), 15000);
		Object a3 = new BankAccount(10, "a1", "b1", AcType.SAVINGS, LocalDate.parse("1990-12-17"),
				LocalDate.parse("2011-12-17"), 15000);
	
		System.out.println(a1 == a2);// f => ref equality
		System.out.println(a1.equals(a2));//t
		String s="hello";
		System.out.println(a1.equals(s));//f : instanceof --> f
		System.out.println(a1.equals(a3));//f : instanceof --> t , BUT acct nos : different

	}

}
