package com.advancejava2.csvfiledata;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.advancejava2.outputdisplay.DisplayOutput;
import com.advancejava2.tshirt.Tshirt;

public class CsvFileData {

	public static void csvFileReader(String path,String[] data ) {
		List<String> matchedData = new ArrayList<String>();
		long start = System.currentTimeMillis();
		long end = start + 20 * 1000;
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() 
		{
			@Override
			public void run() 
			{

				File[] files = new File(path)
						.listFiles(obj -> obj.isFile() && obj.getName().endsWith(".csv"));
				String line = "";
				Configuration config = new Configuration().configure().addAnnotatedClass(Tshirt.class);
				SessionFactory sf = config.buildSessionFactory();
				Session session = sf.openSession();
				for (int j = 0; j < files.length; j++) 
				{
					try (BufferedReader br = new BufferedReader(new FileReader(files[j]))) {
						br.readLine();
						while ((line = br.readLine()) != null) {

							String[] hash = line.split("\\|");
							
							try {
							Tshirt value=new Tshirt();
							value.setId(hash[0]);
							value.setName(hash[1]);
							value.setColor(hash[2]);
							value.setGenderRecommendation(hash[3]);
							value.setSize(hash[4]);
							value.setPrice(Double.parseDouble(hash[5]));
							value.setRating(Double.parseDouble(hash[6]));
							value.setAvailability(hash[7]);
							
							Transaction tx=session.beginTransaction();
							 session.save(value);
							tx.commit();


							System.out.println("Executed Successfully");
							
							}
							catch (Exception e) {
//	
								continue;
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

				DisplayOutput.display(data,matchedData);

				
				if((System.currentTimeMillis() > end))
					{		
					if(matchedData.size()==0)
					System.out.println("No data found");
					else 
					DisplayOutput.display(data,new ArrayList<String>());

					timer.cancel();
					}

			};

		};
		timer.scheduleAtFixedRate(timerTask, new Date(), 1000);

	}

}
