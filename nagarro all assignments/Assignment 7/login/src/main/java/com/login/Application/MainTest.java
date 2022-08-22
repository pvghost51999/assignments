package com.login.Application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {

	public static void main(String[] args) {
//		Configuration confg=new Configuration().configure().addAnnotatedClass(UserDetails.class);
//		SessionFactory sfg=confg.buildSessionFactory();
//		Session session=sfg.openSession();
//		
//		String str="from ProductDetails p where p.details_id='sanu'";
//		TypedQuery<UserProduct> t2=session.createQuery(str);		
//		List<UserProduct> li=t2.getResultList();
//		System.out.println(li.get(0).getName());
//		System.out.println(li);
//		String customer="sanu";
//		String SQL_QUERY ="from ProductDetails order where order.Details.username =sanu";
//       TypedQuery query = session.createQuery(SQL_QUERY);
//        List<ProductDetails> r = query.getResultList();
//        System.out.println(r);
		
//		 CriteriaBuilder builder = session.getCriteriaBuilder();
//		    CriteriaQuery criteria = builder.createQuery(ProductDetails.class);
//		    criteria.from(ProductDetails.class);
//		    List<ProductDetails> data = session.createQuery(criteria).getResultList();
//		    System.out.println(data.get(0).getDetails_id().getUsername());
				
				
	}

}
