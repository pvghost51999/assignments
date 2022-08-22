package com.advancejava2.outputdisplay;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.advancejava2.tshirt.Tshirt;

public class DisplayOutput {

	public static List<String> display(String[] data,List<String> Matched) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Tshirt.class);

		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Query q1 = null;
//		Query q1=session.createQuery("from Tshirt as t order by t.price desc");
		if(data[3].contains("price")&&!data[3].contains("rating"))
		q1=session.createQuery("from Tshirt as t where t.color=:col and t.size=:siz and t.genderRecommendation=:gend order by t.price asc");

		else if(!data[3].contains("price")&&data[3].contains("rating"))
		q1=session.createQuery("from Tshirt as t where t.color=:col and t.size=:siz and t.genderRecommendation=:gend order by t.rating desc");
		
		else if(data[3].contains("price")&&data[3].contains("rating"))
		q1=session.createQuery("from Tshirt as t where t.color=:col and t.size=:siz and t.genderRecommendation=:gend order by t.price asc,t.rating desc");
		
		q1.setString("col", data[0]);
		q1.setString("siz", data[1]);
		q1.setString("gend", data[2]);
		
		List<Tshirt> li=q1.list();
		for(Tshirt t:li)
		{
			if (!Matched.contains(t.getId()))
				{
					Matched.add(t.getId());
					System.out.println();
					System.out.println(t);
					
				}
		}
		return Matched;
		
	}



}
