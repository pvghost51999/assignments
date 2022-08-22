package com.advancejava1.csvfiledata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.advancejava1.outputdisplay.DisplayOutput;
import com.advancejava1.sortfiledata.SortFileData;
import com.advancejava1.tshirt.Tshirt;

public class CsvFileData {

	public static void csvFileReader(String path, String[] data) {
		List<Tshirt> matchedData = new ArrayList<Tshirt>();
		List<String> dublicate = new ArrayList<String>();
		long start = System.currentTimeMillis();
		long end = start + 20 * 1000;
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {

				File[] files = new File("C:\\Users\\prashantverma\\Desktop\\Assigment Links")
						.listFiles(obj -> obj.isFile() && obj.getName().endsWith(".csv"));
				String line = "";
				for (int j = 0; j < files.length; j++) {
					try (BufferedReader br = new BufferedReader(new FileReader(files[j]))) {
						br.readLine();
						while ((line = br.readLine()) != null) {

							String[] hash = line.split("\\|");
							if (!dublicate.contains(hash[0])) {

								dublicate.add(hash[0]);
								if (hash[2].equalsIgnoreCase(data[0]) && hash[4].equalsIgnoreCase(data[1])

										&& hash[3].equalsIgnoreCase(data[2])) {

									Tshirt values = new Tshirt(hash[0], hash[1], hash[2], hash[3], hash[4], hash[5],
											hash[6], hash[7]);
									matchedData.add(values);
								}
							}

						}

					} catch (FileNotFoundException e) {
						System.out.print("file is not found");
						e.printStackTrace();
					}

					catch (IOException e) {
						System.out.println("Error while reading a file");
					}

				}

				if (matchedData.size() == 0 && (System.currentTimeMillis() > end)) {

					System.out.println("No Data Found");
					timer.cancel();
					return;
				}

				if (matchedData.size() != 0) {
					String preference = data[3].toLowerCase();
					List<Tshirt> finalData = SortFileData.sortdata(matchedData, preference);
					System.out.println();
					System.out.println("Available Tshirts:-");
					DisplayOutput.display(finalData);

					timer.cancel();
					return;
				}

			};

		};
		timer.scheduleAtFixedRate(timerTask, new Date(), 1000);

	}

}
