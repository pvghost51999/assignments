package com.login.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.login.Application.UserDetails;
import com.login.Application.UserProduct;






public class HibernateUtility {



public static SessionFactory sf;
//to disallow creating objects by other classes.



private HibernateUtility() {
}
//maling the Hibernate SessionFactory object as singleton



public static synchronized SessionFactory getSessionFactory() {



if (sf == null) {
sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserDetails.class).addAnnotatedClass(UserProduct.class).buildSessionFactory();

//Configuration config = new Configuration().configure().addAnnotatedClass(UserDetails.class).addAnnotatedClass(UserProduct.class);
//ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
//.getBootstrapServiceRegistry();
//sf = config.buildSessionFactory(registry);
Session session=sf.openSession();
return sf;
}
return sf;
}
}

