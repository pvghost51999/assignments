package com.carinsurance.validations;

import java.util.Scanner;

public class CarValidation {

	public String Valchek(Scanner vc) {
		// Checking whether user is giving correct y/n values

		String yes = "y";

		boolean done = false;
// user have to type until it is not validating the correct form
		while (!done) {
			try {
				yes = vc.nextLine();
				if (!yes.equalsIgnoreCase("y") && !yes.equalsIgnoreCase("n"))
					throw new Exception();
				done = true;
			} catch (Exception e) {

				System.out.println("Please enter valid y/n");
			}
		}
		return yes;

	}

}
