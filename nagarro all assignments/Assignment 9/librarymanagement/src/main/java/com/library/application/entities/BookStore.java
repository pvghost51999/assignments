package com.library.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class BookStore {
	


	public BookStore(int bcode, String bname, String bauthor, String badddate) {
		super();
		this.bcode = bcode;
		this.bname = bname;
		this.bauthor = bauthor;
		this.badddate = badddate;
	}
	@Id
	@Column(name = "book_code")
	private int bcode;
	@Column(name = "book_name")
	private String bname;
	@Column(name = "book_author") 
	private String bauthor;
	@Column(name = "book_date")
	private String badddate;
	
	public BookStore() {
		super(); 
		// TODO Auto-generated constructor stub
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBadddate() {
		return badddate;
	}
	public void setBadddate(String badddate) {
		this.badddate = badddate;
	}
	@Override
	public String toString() {
		return "BookStore [bcode=" + bcode + ", bname=" + bname + ", bauthor=" + bauthor + ", badddate=" + badddate
				+ "]";
	}
	

	

}
