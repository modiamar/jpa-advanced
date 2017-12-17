package com.example.demo.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Passport;
import com.example.demo.domain.Student;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

	@PersistenceContext
	private EntityManager em;
	
	public StudentRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Student findById(Long id) {
		Student student = em.find(Student.class, id);
		return student;
	}

	@Override
	public Student insert(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	@Override
	public void deleteById(Long id) {
		Student studentDeleted = this.findById(id);
		em.remove(studentDeleted);		
	}
	
	@Override
	public void bootstrapData() {
		Student student = em.find(Student.class, 10003L);
		Passport passport = student.getPassport();
		passport.setNumber("123477788");
		student.setName("Waffle");
		em.flush();
	}
	
	@Override
	public void saveStudentWithPassport() {
		Passport passport = new Passport("1234788");
		em.persist(passport);
		// To actually add the OneToOne relationship, you have to set the Passport to the Student
		Student student = new Student("AMY");
		student.setPassport(passport);
		em.persist(student);
	}

}
