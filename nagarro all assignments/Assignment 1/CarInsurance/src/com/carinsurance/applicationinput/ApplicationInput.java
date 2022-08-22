package com.carinsurance.applicationinput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.carinsurance.calculate.CalculateInsurance;
import com.carinsurance.carclass.CarClass;
import com.carinsurance.consoleinput.ConsoleInput;
import com.carinsurance.exceptionhandlings.CarExceptionHandling;
import com.carinsurance.validations.CarValidation;

public class ApplicationInput {

	public static void main(String[] args) {

		List<String> args_list = Arrays.asList(args);
		Scanner sc = new Scanner(System.in);
		ArrayList<String> store = new ArrayList<>();
		String yes = "y";
		List<CarClass> all_data_list = new ArrayList<>();
		boolean entry = false;
// using an do while loop to execute first statement without taking input for the first time

		do {
			/**
			 * taking input from console if entry is true it means it should have executed
			 * at least once from the command line after that it should come to take user
			 * input
			 */
			if (entry) {

				ConsoleInput Input_variable = new ConsoleInput();
				args_list = Input_variable.Input(sc, args_list);

			}

			/**
			 * Validating the values whether it should be taken or not it means that the
			 * input is correct or not
			 */
			CarExceptionHandling value = new CarExceptionHandling();
// store will hold the list of string that will come after Validating from Validate class
			store = value.vali(args_list);

// Here checking whether all the inputs are satisfying the condition or not
			if (Integer.parseInt(store.get(0)) == 0) {

// making an object of Car_value class which hold private variables
				CarClass Car_class = new CarClass(store.get(2), store.get(1), Double.parseDouble(store.get(3)),
						store.get(4));

				/**
				 * All_Values is a list which will store all the details of car in list form
				 * inside All_Values
				 */

				all_data_list.add(Car_class);
				System.out.println("Do you want to enter another details of any other car (y/n):");

				/**
				 * it will check whether the user entering correct y/n if not it will raise an
				 * error
				 */
				CarValidation valchck = new CarValidation();
				yes = valchck.Valchek(sc);

// Otherwise user have to try Again
			}

			else {
				System.out.println("Try again\n");
			}

// clearing the car details for storing new values provided bY user in 94 line
			entry = true;
// clearing user input provide in 56 line
			args_list = new ArrayList<>();

		} while (yes.equals("y"));

// calling calculating class to calculate total insurance
		CalculateInsurance value = new CalculateInsurance();
		value.calculating(all_data_list);
		sc.close();
	}

}
