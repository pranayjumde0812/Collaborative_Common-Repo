package com.vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.color.Color;
import com.exception.ColorNotFoundException;
import com.exception.DuplicateChasisException;
import com.exception.PollutionExceededException;
import com.validation.ValidateVehicle;

public class Main {

	public static void main(String[] args) {

		String chasisNo;
		double price, pollutionLevel;
//		Date manufactureDate, insuranceExpiryDate;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vehicles");
		int size = sc.nextInt();
		Vehicle[] v = new Vehicle[size];
		ArrayList<String> ch = new ArrayList<>();

		try {
			for (int i = 0; i < v.length; i++) {
				System.out.println("Enter chasis number ");
				chasisNo = ValidateVehicle.duplicateChasis(sc.next(), ch);
				ch.add(chasisNo);

				System.out.println("Enter price ");
				price = sc.nextDouble();

				System.out.println("Enter pollution level");
				pollutionLevel = ValidateVehicle.pollutionValidation(sc.nextDouble());

				Date dt = new Date();
				System.out.println("Enter the manufacturing date");
				dt.setDate(sc.nextInt());
				System.out.println("Enter the manufacturing month");
				dt.setMonth(sc.nextInt());
				System.out.println("Enter the manufacturing year");
				dt.setYear(sc.nextInt());
//		 System.out.println("Enter manufacturing date");
				Date insDt = new Date();
				System.out.println("Enter the insurance expiry date");
				insDt.setDate(sc.nextInt());
				System.out.println("Enter the insurance expiry month");
				insDt.setMonth(sc.nextInt());
				System.out.println("Enter the insurance expiry year");
				insDt.setYear(sc.nextInt());
//		 System.out.println("Enter insurance expiry date");
//				System.out.println("Enter the manufacturing date (dd/MM/yyyy): ");
//                Date manufactureDate = dateFormat.parse(sc.next());
//
//                System.out.println("Enter the insurance expiry date (dd/MM/yyyy): ");
//                Date insuranceExpiryDate = dateFormat.parse(sc.next());
				
				System.out.println("Enter the color");
				Color c = ValidateVehicle.colorValidation(sc.next());

				v[i] = new Vehicle(chasisNo, price, pollutionLevel, dt, insDt, c);
			}
			for (int j = 0; j < v.length; j++) {
				System.out.println(v[j]);
			}
		} catch (DuplicateChasisException | PollutionExceededException | ColorNotFoundException e) {
			e.printStackTrace();
			return;
		}

	}

}
