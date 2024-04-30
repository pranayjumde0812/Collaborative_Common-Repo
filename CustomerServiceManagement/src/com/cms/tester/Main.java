package com.cms.tester;

import java.util.ArrayList;
import java.util.Scanner;

import static com.cms.utility.Unsubscribe.*;

import static com.cms.utility.SignIn.*;
import static com.cms.utility.SignUp.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Customer> c = new ArrayList<>();
		try(Scanner sc = new Scanner(System.in)){
			int choice;

			do{
				System.out.println("1. Signup\n"+"2. Signin\n"+"3. change email\n"+"4. display all users\n"+"0. exit");
				System.out.println("Enter the choice");
				choice= sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Sign up");
					c.add(signUp(c));
					break;
				case 2:
					System.out.println("Sign in");
					System.out.println("Enter email");
					String email = sc.next();
					System.out.println("Enter password");
					String password = sc.next();
					System.out.println(isRegistered(c, email,password));
					
					break;
				case 3:
					System.out.println("Changing the email");
					System.out.println("enter current mail id");
					String currEmail = sc.next();
					isEmailPresent(c, currEmail);
					System.out.println("enter new mail id");
					String newEmail = sc.next();
					changeEmail(c, currEmail, newEmail);
					break;
				case 4:
					System.out.println("unsubscribe page");
					System.out.println("enter email");
					String e = sc.next();
					isEmailPresent(c, e);
					System.out.println("enter password");
					String p = sc.next();
					unSubscribe(c,e,p);

					break;
				case 5:
					System.out.println(c);
				case 0:
//					return;
					break;
				}
			}while(choice !=0);
				
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
