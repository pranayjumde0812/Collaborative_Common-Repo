package com.cms.tester;

import static com.cms.utility.SignIn.isRegistered;
import static com.cms.utility.SignUp.signUp;
import static com.cms.utility.Unsubscribe.unSubscribe;
import static com.cms.utility.Utilities.changePassword;
import static com.cms.utility.Utilities.isEmailPresent;
import static com.cms.utility.Utilities.removeAfterGivenDobAndPlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.cms.utility.CustomerDateAndLastNameComparator;

public class Main {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			do {
				System.out.println("1. Signup\n" + "2. Signin\n" + "3. change password\n" + "4. Unsubscribe\n"
						+ "5. display all users\n" + "6. delete for the given plan and after given dob\n" + "7. sort by email\n"
						+ "8. sort by name and dob\n" + "9. exit");
				System.out.println("Enter the choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Sign up");
						signUp(customers, sc);
						System.out.println("hello");

						break;
					case 2:
						System.out.println("Sign in");
						System.out.println("Enter email");
						String email = sc.next();
						System.out.println("Enter password");
						String password = sc.next();
						System.out.println(isRegistered(customers, email, password));

						break;
					case 3:
						System.out.println("Changing the password");
						System.out.println("enter the mail id");
						String currEmail = sc.next();
						isEmailPresent(customers, currEmail);
						System.out.println("enter new password");
						String newPassword = sc.next();
						changePassword(customers, currEmail, newPassword);
						break;
					case 4:
						System.out.println("unsubscribe page");
						System.out.println("enter email");
						String e = sc.next();
						isEmailPresent(customers, e);

						unSubscribe(customers, e);

						break;
					case 5:
						System.out.println(customers);
						break;
					case 6:
						System.out.println("Enter the plan and date from which customers to be deleted");
						removeAfterGivenDobAndPlan(sc.next(), sc.next(), customers);
						break;
					case 7:
						System.out.println("sorting customers by email in ascending order");
						Collections.sort(customers);
						break;
					case 8:
						System.out.println("sorting customers by dob and lastname ascending order");
						Collections.sort(customers, new CustomerDateAndLastNameComparator());
						break;
					case 9:
						System.out.println("Exit from api");
						exit = true;
						break;
//					case 0:
//						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			} while (!exit);

		}
	}

}
