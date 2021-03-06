package com.example.demo.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Course;
import com.example.demo.domain.Review;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryImplTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testFindByIdBasic() {
		Course course = courseRepository.findById(10001L);
		assertEquals("JPA in 50 Steps",course.getName());
		//fail("Not yet implemented");
		//logger.info("Test is running");
	}

	@Test
	@DirtiesContext
	public void testInsertCourse() {
		Course course = new Course("English");
		Course insert = courseRepository.insert(course);
		
		assertEquals(course,insert);
	}
	
	@Test
	@DirtiesContext
	public void testUpdateCourse() {
		Course courseOld = courseRepository.findById(10001L);
		courseOld.setName("Winter");
		Course insert = courseRepository.insert(courseOld);
		
		assertEquals(courseOld,insert);
	}
	
	@Test
	@DirtiesContext // After this test is run, Spring would reset data
	public void testDeleteByIdBasic() {
		courseRepository.deleteById(10001L);
		assertNull(null, courseRepository.findById(10001L));
	}
	
	@Test 
	@Transactional
	public void retrieveReviewsForCourse() {
		System.out.println("LTROTNMNRWOMNMTRMNTWRONMT");
		Course course = courseRepository.findById(10002L);
		System.out.println(course.getReviews());
	}
	
	@Test 
	@Transactional
	public void retrieveCourseFromReviews() {
		Review review = entityManager.find(Review.class, 10043L);
		Course course = review.getCourse();
		System.out.println(course);
		
	}
}
