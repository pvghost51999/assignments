package com.advancejava1.outputdisplay;

import java.util.List;

import com.advancejava1.tshirt.Tshirt;

public class DisplayOutput {

	public static void display(List<Tshirt> finalData) {

		for (int i = 0; i < finalData.size(); i++) {
			System.out.println(finalData.get(i).getId() + "|" + finalData.get(i).getName() + "|"
					+ finalData.get(i).getColor() + "|" + finalData.get(i).getGenderRecommendation() + "| "
					+ finalData.get(i).getSize() + "|" + finalData.get(i).getPrice() + "| "
					+ finalData.get(i).getRating() + " |" + finalData.get(i).getAvailability());
		}
	}

}
