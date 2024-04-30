package com.app.banking;
/*
 * state - account no , customer name(first name last name), 
 * account type , customer dob , a/c creation date , balance

 */

import java.time.LocalDate;

import com.app.custom_exceptions.BankingException;

import static com.app.utils.BankingValidations.*;

public class BankAccount {
//tight encapsulation
	private int acctNo;
	private String firstName;
	private String lastName;
	private AcType acType;
	private LocalDate dob;
	private LocalDate creationDate;
	private double balance;

	public BankAccount(int acctNo, String firstName, String lastName, AcType acType, LocalDate dob,
			LocalDate creationDate, double balance) {
		super();
		this.acctNo = acctNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.acType = acType;
		this.dob = dob;
		this.creationDate = creationDate;
		this.balance = balance;
	}
	//add overloaded ctor to wrap : acct no
	public BankAccount(int acctNo) {
		this.acctNo=acctNo;
	}

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", firstName=" + firstName + ", lastName=" + lastName + ", acType="
				+ acType + ", dob=" + dob + ", creationDate=" + creationDate + ", balance=" + balance + "]";
	}

	// add Business logic methods --for withdraw , deposit n fund transfer
	// deposit method
	public double deposit(double amount) {
		this.balance += amount;
		return balance;
	}

	// withdraw funds
	public double withdraw(double amount) throws BankingException {
		// validateBalance
		validateBalance(this.acType, balance - amount);
		this.balance -= amount;
		return balance;
	}

	// transfer funds
	public BankAccount transferFunds(BankAccount dest, double amount) throws BankingException {
		this.withdraw(amount);
		// => withdrwan : successfully
		dest.deposit(amount);
		return dest;
	}

	// override equals method inherited from Object class , to replace ref equality
	// by UID based equality
	// eg : acct no
	@Override
	public boolean equals(Object o) {
//		System.out.println("in acct's equals");
		if (o instanceof BankAccount) {
			return this.acctNo == ((BankAccount) o).acctNo;
		}
		return false;
	}

}
