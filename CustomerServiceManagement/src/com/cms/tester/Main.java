package com.cms.tester;

import java.util.ArrayList;
import java.util.Scanner;

import static com.cms.utility.SignIn.*;
import static com.cms.utility.SignUp.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Customer> c = new ArrayList<>();
		try(Scanner sc = new Scanner(System.in)){
			int choice;

			do{
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
				}
			}while(choice !=0);
				
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
