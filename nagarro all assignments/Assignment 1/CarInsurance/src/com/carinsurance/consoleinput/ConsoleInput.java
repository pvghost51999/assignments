package com.carinsurance.consoleinput;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

	/**
	 * Input.
	 *
	 * @param sc        it is the scanner file
	 * @param args_list is the list of data
	 * @return the list
	 */
	public List<String> Input(Scanner sc, List<String> args_list) {

		System.out.println("Enter Car details:-");
// we are adding -model additional because it will valid for both console and command line		
		System.out.print("-model ");
		args_list.add("-model");
		String Car_Model = sc.nextLine();
// adding car model type enter by user		
		args_list.add(Car_Model);
		System.out.print("-type ");
		args_list.add("-type");
		String Car_Type = sc.nextLine();
		args_list.add(Car_Type);
		args_list.add("-cost");
		System.out.print("-cost ");
		String Car_Cost = sc.nextLine();
		args_list.add(Car_Cost);
		args_list.add("-insurance");
		System.out.print("-insuracne ");
		String Car_Insurance = sc.nextLine();
		args_list.add(Car_Insurance);

		return args_list;
	}

}
