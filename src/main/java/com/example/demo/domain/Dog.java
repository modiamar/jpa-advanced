package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dog {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToOne(mappedBy = "dog")
	private Owner owner;

	public Dog() {}
	
	public Dog(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", owner=" + owner + "]";
	}
	
	
	
}
