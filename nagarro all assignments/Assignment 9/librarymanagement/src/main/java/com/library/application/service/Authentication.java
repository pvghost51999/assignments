//package com.library.application.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.library.application.dao.Userrepo;
//import com.library.application.entities.User;
//
//@Component
//public class Authentication {
//	@Autowired
//	Userrepo repo;
//
//	public boolean validate(String username,String password)
//	{
//		
//		if(repo.findByUsername(username) != null)
//		{
//			User user=repo.findByUsername(username);
//			if(user.getPassword().equals(password))
//				return true;
//		
//			return false;
//		}
//		return false; 
//	} 
//}
// 