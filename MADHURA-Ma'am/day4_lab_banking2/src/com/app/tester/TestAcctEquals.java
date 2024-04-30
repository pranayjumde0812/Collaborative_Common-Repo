package com.app.tester;

import java.time.LocalDate;

import com.app.banking.AcType;
import com.app.banking.BankAccount;

public class TestAcctEquals {

	public static void main(String[] args) {
		BankAccount a1 = new BankAccount(101, "a1", "b1", AcType.SAVINGS, LocalDate.parse("1990-12-17"),
				LocalDate.parse("2011-12-17"), 15000);
		BankAccount a2 = new BankAccount(101, "a1", "b1", AcType.SAVINGS, LocalDate.parse("1990-12-17"),
				LocalDate.parse("2011-12-17"), 15000);
		System.out.println(a1 == a2);// f => ref equality
		System.out.println(a1.equals(a2));// t => PK equality

	}

}
