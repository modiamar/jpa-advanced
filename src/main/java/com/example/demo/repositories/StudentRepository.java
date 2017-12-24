package com.example.demo.repositories;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;

public interface StudentRepository {
	
	public Student findById(Long id);
	public Student insert(Student student);
	public void deleteById(Long id);
	void saveStudentWithPassport();
	void bootstrapData();
	public void addCoursesToStudent(Long id, Course course);
	//public void insertStudentAndCourse();
	public void insertStudentAndCourse(Student student, Course course);
}
