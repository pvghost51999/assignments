package com.login.validateusername;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.login.Application.UserDetails;
import com.login.Application.UserProduct;
import com.login.session.HibernateUtility;

public class ValidateUsername {
	public static Session fetch(String username,String password){
		
	Session session=HibernateUtility.getSessionFactory().getCurrentSession();	
//	Configuration config = new Configuration().configure().addAnnotatedClass(UserDetails.class);
//	SessionFactory sf = config.buildSessionFactory();
//	Session session = sf.openSession();
//	System.out.println((session).toString());
	Transaction tx=session.beginTransaction();
	TypedQuery<UserProduct> q1=session.createQuery("from UserDetails where username=:u and password=:p");
		q1.setParameter("u", username);
		q1.setParameter("p", password);
//	System.out.println(username+ password);
	List l=q1.getResultList();
	tx.commit();
	if(l.size()==1)
		return session;
	return null;
	
	}


}
