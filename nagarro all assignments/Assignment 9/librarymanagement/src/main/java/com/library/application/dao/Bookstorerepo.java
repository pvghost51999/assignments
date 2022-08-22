package com.library.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.library.application.entities.BookStore;





public interface Bookstorerepo  extends JpaRepository<BookStore, Integer>{

//	   @Query(value = "DELETE FROM BookStore e WHERE e.bcode= :code")       // it will delete all the record with specific name
//	    int deleteByBcode(@Param("name") Integer code);
	
}
 