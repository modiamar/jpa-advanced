package com.example.demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//OneToMany Relationship with Review
@Entity
@NamedQueries({
	@NamedQuery(name = "find_by_name", query= "Select c from Course c where c.name = :name"),
	@NamedQuery(name = "find_by_id", query= "Select c from Course c where c.id = :id"),
	@NamedQuery(name = "find_all", query= "Select c from Course c")
})
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false) // name cannot have a null value
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	public Course() {}
	
	public Course(String name) {
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
