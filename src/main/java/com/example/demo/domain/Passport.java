package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	private String number;

	//private Student student;
	
	public Passport() {
		
	}
	
	public Passport(String number) {
		super();
		this.number = number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Long getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
	
	

}
