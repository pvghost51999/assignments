package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.library.entities.User;


@Component
public class Authentication {
	@Autowired
	HibernateTemplate hibernateTemplate;

	public boolean validate(String username,String password)
	{
		
			User user=hibernateTemplate.get(User.class, username);
			if(user!=null&& user.getPassword().equals(password))
			{
				return true;
			
			}else {
				return false;
			}
			
	}
}

