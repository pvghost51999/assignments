package com.library.application.dao;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.library.application.entities.User;


public interface Userrepo extends JpaAttributeConverter<User,String> {


	User findByUsername(String username);

	

	
}