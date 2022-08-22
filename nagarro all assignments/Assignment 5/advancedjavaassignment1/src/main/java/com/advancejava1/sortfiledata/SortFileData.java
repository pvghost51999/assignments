package com.advancejava1.sortfiledata;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.advancejava1.tshirt.Tshirt;

public class SortFileData {
	public static Double makeDouble(String price) {
		return Double.parseDouble(price);

	}

	public static List<Tshirt> sortdata(List<Tshirt> inform, String preference)

	{

		Comparator<Tshirt> val = new Comparator<Tshirt>() {
			String first, second;

			@Override
			public int compare(Tshirt o1, Tshirt o2) {
				if (preference.contains("price") && preference.contains("rating")) {
					if ((makeDouble(o1.getPrice()) == makeDouble(o2.getPrice()))
							&& (makeDouble(o1.getRating()) == makeDouble(o2.getRating()))) {
						return 0;
					} else if ((makeDouble(o1.getPrice()) > makeDouble(o2.getPrice()))
							&& (makeDouble(o1.getRating()) < makeDouble(o2.getRating())))
						return 1;
					else
						return -1;
				} else if (preference.contains("price") && !preference.contains("rating")) {
					first = o1.getPrice();
					second = o2.getPrice();
					if (makeDouble(first) > makeDouble(second)) {
						return 1;
					} else
						return -1;
				} else if (preference.contains("rating") && !preference.contains("price")) {
					first = o2.getRating();
					second = o1.getRating();
					if (makeDouble(first) > makeDouble(second)) {
						return 1;
					} else
						return -1;
				}

				return 0;
			}
		};

		Collections.sort(inform, val);
		return inform;
	}

}
