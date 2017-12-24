package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domain.Course;
import com.example.demo.domain.Review;
import com.example.demo.domain.Student;

public interface CourseRepository {
	
	public Course findById(Long id);
	public Course insert(Course course);
	public void deleteById(Long id);
	public void addReviewsForCourse(Long id, List<Review> reviews);
	void addReviewsForCourseBackwards();
	public void addStudentToCourse (Long id, Student student);
}
