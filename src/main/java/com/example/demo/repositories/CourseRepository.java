package com.example.demo.repositories;

import com.example.demo.domain.Course;

public interface CourseRepository {
	
	public Course findById(Long id);
	public Course insert(Course course);
	public void deleteById(Long id);
}
