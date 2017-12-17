package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//ManyToOne relationship
@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String rating;
	
	private String description;

	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}
	
	
	public Review() {
		
	}


	public Long getId() {
		return id;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
