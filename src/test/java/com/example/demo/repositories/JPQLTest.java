package com.example.demo.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void testFindById() {
		//This is JPQL
		String statement = "Select c from Course c where c.id = :id";
		TypedQuery<Course> query = em.createNamedQuery("find_by_id", Course.class);
		Course course = query.setParameter("id", 10001L).getSingleResult();
		assertEquals("JPA in 50 Steps", course.getName());
	}
	
	@Test
	public void testFindByName() {
		//This is JPQL
		String statement = "Select c from Course c where c.name = :name";
		TypedQuery<Course> query = em.createNamedQuery("find_by_name", Course.class);
		Course course = query.setParameter("name", "JPA in 50 Steps").getSingleResult();
		assertEquals("JPA in 50 Steps", course.getName());
		
	}
	
	@Test
	public void testInsert() {
		//This is JPQL
		String statement = "Select c from Course c where c.name = :name";
		TypedQuery<Course> query = em.createQuery(statement, Course.class);
		Course course = query.setParameter("name", "JPA in 50 Steps").getSingleResult();
		assertEquals("JPA in 50 Steps", course.getName());
	}
	
	@Test
	public void testNativeQueries() {
		String statement = "Select * from Course";
		Query createNativeQuery = em.createNativeQuery(statement, Course.class);
		List<Course> resultList = createNativeQuery.getResultList();
		resultList.forEach(course -> {
			System.out.println(course);
		});
	}
	
	@Test
	public void testNativeQueryAdvanced() {
		//This is a native query
		String statement = "Select * from Course where id = :id";
		Query createNativeQuery = em.createNativeQuery(statement, Course.class);
		
		@SuppressWarnings("unchecked")
		List<Course> resultList = createNativeQuery.setParameter("id", 10001L).getResultList();
		
		resultList.forEach(course -> {
			System.out.println(course);
		});
	}
	
	@Test
	@Transactional
	public void testNativeQueryAdvancedUpdate() {
		String statement = "Update Course set last_updated_date = sysdate()";
		Query createNativeQuery = em.createNativeQuery(statement, Course.class);
		int rowsAffected = createNativeQuery.executeUpdate();
		System.out.println(rowsAffected);
	}
}
