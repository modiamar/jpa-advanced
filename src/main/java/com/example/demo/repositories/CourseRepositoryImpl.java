package com.example.demo.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Course;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public CourseRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Course findById(Long id) {
		Course course = entityManager.find(Course.class, id);
		return course;
	}

	@Override
	public Course insert(Course course) {
		entityManager.merge(course);
		return course;
	}

	@Override
	public void deleteById(Long id) {
		Course course = this.findById(id);
		entityManager.remove(course);
	}
	
	//@Override // When you are inside of one method, EntityManager manages EVERYTHING for all changes for you
	public void playingWithEntityManager() {
		Course course = new Course("Manager");
		entityManager.persist(course); //Now any changes that happen on course will be managed by EntityManager and updated
		course.setName("Hibernate + Spring Boot");
	}
	
	//@Override // When you are inside of one method, EntityManager manages EVERYTHING for all changes for you
	public void playingWithEntityManager2() {
		Course course1 = new Course("Manager");
		entityManager.persist(course1); //Now any changes that happen on course will be managed by EntityManager and updated
		
		Course course2 = new Course("Angular");
		entityManager.persist(course2); //Now any changes that happen on course will be managed by EntityManager and updated
		
		entityManager.flush();
		entityManager.clear(); // detaches ALL entities
		entityManager.detach(course2); //this means changes are no longer tracked on this entity
		
		course1.setName("Hibernate + Spring Boot");
		course2.setName("Hibernate44444 + Spring Boot");
		entityManager.flush(); //Changes after that point are sent out to db
	}

	//@Override
	public void playingWithEntityManager3() {
		Course course1 = new Course("Manager");
		entityManager.persist(course1);
		Course course2 = new Course("Angular");
		entityManager.persist(course2); 
		entityManager.flush();
		
		course1.setName("Hibernate + Spring Boot");
		course2.setName("Hibernate44444 + Spring Boot");
		entityManager.refresh(course1); //refreshes entity to what is currently in db
		System.out.println(course1);
		entityManager.flush(); //Changes after that point are sent out to db
		
	}
	

}
