package com.example.demo.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Course;
import com.example.demo.domain.Review;
import com.example.demo.domain.Student;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {
	
	class HelloWorld {
		
		private String hello;

		public HelloWorld(String hello) {
			super();
			this.hello = hello;
		}
	}

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public CourseRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Course findById(Long id) {
		HelloWorld helloWorld = new HelloWorld("hello");
		Course course = entityManager.find(Course.class, id);
		return course;
	}

	@Override
	public Course insert(Course course) {
		if(course.getId() == null) {
			entityManager.persist(course);
			return course;
		}
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

	@Override
	public void addReviewsForCourse(Long id, List<Review> reviews) {
		Course course = this.findById(id);
		reviews.forEach(review ->{
			// because we adding the review to course
			course.addReview(review);
			// because Review is primary set it
			review.setCourse(course);
			entityManager.persist(review);
		});
	}
	
	@Override
	public void addReviewsForCourseBackwards() {
		Review review = entityManager.find(Review.class, 10045L);
		Course course = new Course("Eryutrhimics");
		course.addReview(review);
		entityManager.persist(course);
		review.setCourse(course);
		System.err.println(review);
		//entityManager.merge(review);
		
	}

	@Override //REMEMBER: For ManyToMany : Add to BOTH SIDES ManyToOne add to owning side
	public void addStudentToCourse(Long id, Student student) {
		entityManager.persist(student);
		Course course = findById(id);
		course.addStudent(student);
		student.addCourse(course);
		
	}
}
