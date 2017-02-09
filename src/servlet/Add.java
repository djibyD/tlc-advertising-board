package servlet;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Add {

	//@Parent Key<Adds> adds;
	@Id public Long id;

	public String title;
	public String price;
	@Index public Date date;

	/**
	 * Simple constructor
	 **/
	public Add() {

	}

	/**
	 * constructor with parameters
	 **/
	public Add(String title, String price, Date date) {
		this.title=title;
		this.price= price;
		this.date=date;
	}

}
