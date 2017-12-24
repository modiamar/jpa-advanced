package com.example.demo.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Course;
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
		Student student = findById(10003L);
		//Passport passport = student.getPassport();
		Passport passport = new Passport("123478338LLL");
		//passport.setStudent(student);
		em.persist(passport);
		student.setPassport(passport);
		//em.persist(student);
		
	}
	
	@Override
	public void saveStudentWithPassport() {
		Passport passport = em.find(Passport.class, 40001L);
		
		Student student = new Student("rworot");
		
		student.setPassport(passport);
		passport.setStudent(student);
		insert(student);
	}

	@Override
	public void addCoursesToStudent(Long id, Course course) {
		em.persist(course);
		Student student = findById(id);
		student.addCourse(course);
		course.addStudent(student);
		
	}

	@Override
	public void insertStudentAndCourse(Student student, Course course) {
		//Student student = new Student("LOng");
		//Course course = new Course("English");
		em.persist(course);
		em.persist(student);
		student.addCourse(course);
		course.addStudent(student);
		
	}
	
	
	

}
