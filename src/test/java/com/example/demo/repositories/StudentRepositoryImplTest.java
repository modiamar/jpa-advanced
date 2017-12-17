package com.example.demo.repositories;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Passport;
import com.example.demo.domain.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryImplTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	EntityManager em;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	@Transactional
	public void someTest() {
		bootstrapData();
	}

	public void bootstrapData() {
		Student student = em.find(Student.class, 10003L);
		Passport passport = student.getPassport();
		passport.setNumber("123477788");
		student.setName("Waffle");
		em.flush();
	}

	@Test
	@Transactional
	public void testGetStudentWithPassport() {
		Student student = em.find(Student.class, 10003L);
		System.err.println(student);
		Passport passport = student.getPassport();
		System.err.println(passport);
	}

}
