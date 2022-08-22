package com.carinsurance.exceptionhandlings;

import java.util.ArrayList;
import java.util.List;

public class CarExceptionHandling {
	public ArrayList<String> vali(List<String> l) {
		// storing the Index value of Model type cost and insurance type
		ArrayList<String> store = new ArrayList<String>();

		int ValModel = l.indexOf("-model") + 1;
		int ValType = l.indexOf("-type") + 1;
		int ValCost = l.indexOf("-cost") + 1;
		int ValInsurance = l.indexOf("-insurance") + 1;
		int c = 0;

//Checking for whether the car type is present or not In the
		// using contain method

		if (!(l.get(ValType).equalsIgnoreCase("Hatchback")) && !(l.get(ValType).equalsIgnoreCase("sedan"))
				&& !(l.get(ValType).equalsIgnoreCase("suv"))) {
			c = 1;
			System.out.println("Please choose only Hatchback/Sedan/SUV:-");

		}

//Validating the cost type whether it contains all double or not using try and catch 
		Double check = 0.0;

		try {

			check = Double.parseDouble(l.get(ValCost));
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid cost");
			c = 1;
		}
		if (check < 0) {
			System.out.println("Please enter cost greater than 0");
			c = 1;
		}

//Checking for whether the Insurance type is present or not In the {Ty} Arraylist
		// using contain method
		if (!(l.get(ValInsurance).equalsIgnoreCase("premium")) && !(l.get(ValInsurance).equalsIgnoreCase("basic"))) {

			c = 1;

			System.out.println("Please choose only  Premimum/Basic:-");
		}
		store.add(Integer.toString(c));
		store.add(l.get(ValType));
		store.add(l.get(ValModel));
		store.add(Double.toString(check));
		store.add(l.get(ValInsurance));
		return store;
	}

}
