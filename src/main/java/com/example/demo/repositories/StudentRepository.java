package com.example.demo.repositories;

import com.example.demo.domain.Student;

public interface StudentRepository {
	
	public Student findById(Long id);
	public Student insert(Student student);
	public void deleteById(Long id);
	void saveStudentWithPassport();
	void bootstrapData();
}
