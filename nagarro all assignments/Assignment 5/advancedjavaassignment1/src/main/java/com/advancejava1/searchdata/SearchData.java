package com.advancejava1.searchdata;

import java.util.List;
import java.util.Scanner;

import com.advancejava1.csvfiledata.CsvFileData;
import com.advancejava1.tshirt.Tshirt;

public class SearchData implements Runnable {

	public static List<Tshirt> fileData;

	@Override
	public void run() {

		Scanner sc = new Scanner(System.in);
		String[] data = new String[4];

		for (int i = 0; i < 4; i++) {
			int check = 0;
			switch (i) {
			case 0:
				System.out.println("Color:");

				break;
			case 1:
				System.out.println("Size:");
				break;
			case 2:
				System.out.println("Gender:");
				break;
			case 3:
				System.out.println("Output Preference:");
				break;
			}
			data[i] = sc.nextLine();
			while ((i == 1) && check == 0) {
				if (!data[i].equalsIgnoreCase("m") && !data[i].equalsIgnoreCase("l") && !data[i].equalsIgnoreCase("xl")
						&& !data[i].equalsIgnoreCase("xxl") && !data[i].equalsIgnoreCase("s")) {
					System.out.println("Please choose only S|M|L|XL|XXL");
					data[i] = sc.nextLine();
				} else {
					check = 1;
				}
			}

			while ((i == 2) && check == 0) {
				if (!data[i].equalsIgnoreCase("f") && !data[i].equalsIgnoreCase("m")) {

					System.out.println("Please choose only M|F");
					data[i] = sc.nextLine();
				} else {
					check = 1;
				}
			}
		}
		String path = "C:\\Users\\prashantverma\\Desktop\\Assigment Links";
		CsvFileData.csvFileReader(path, data);
		sc.close();
	}

}
