package com.carinsurance.calculate;

import java.util.HashMap;
import java.util.List;

import com.carinsurance.carclass.CarClass;

public class CalculateInsurance {

	/**
	 * Calculating.
	 *
	 * @param carList it will hold the car details
	 */
	public void calculating(List<CarClass> carList) {
		HashMap<String, Integer> check = new HashMap<String, Integer>();
// we are adding details in the hashmap
		check.put("hatchback", 5);
		check.put("sedan", 8);
		check.put("suv", 10);
		check.put("premium", 20);
		check.put("basic", 0);
		int i = 0;
		for (CarClass car : carList) {
			// type of car will be stored in type
			String type = car.getType();
			// cost of the car
			Double cost = car.getCost();
			// type of insurance
			String insurance = car.getInsurance();
			int dis = check.get(type);
			int ins_type = check.get(insurance);
			// discount on the price before adding insurance type
			Double price_dis = ((cost * dis) / 100);
			// Result after adding insurance type
			Double result = price_dis + ((price_dis * ins_type) / 100);
			System.out.println("CarModel " + (i + 1) + " = " + car.getModel() + " Type=" + type
					+ " CarInsurance to be paid=" + result + "\n");

		}

	}
}
