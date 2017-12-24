package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Course;
import com.example.demo.domain.Review;
import com.example.demo.domain.Student;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.DogRepository;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private DogRepository dogRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		courseRepository.insert(new Course("Math"));
		Course course = courseRepository.findById(10001L);
		logger.info("Course with id is {}", course);
		course.setName("bonbribnr");
		courseRepository.insert(course);
		System.out.println(courseRepository.findById(10001L)); 
		*/
		
		//studentRepository.bootstrapData();
		
		//Dog dog = dogRepository.findById(10004L);
		//System.out.println(dog.getOwner());
		/**
		Review review = new Review("4", "Terrible");
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(review);
		reviews.add(review);
		studentRepository.insert(new Student("Rtyt"));
		courseRepository.insert(new Course("Hello World"));
		courseRepository.addReviewsForCourseBackwards();
		studentRepository.saveStudentWithPassport();
		**/
		//Course course = courseRepository.findById(10001L);
		//studentRepository.addCoursesToStudent(10003L, course);
		//Student student = new Student("JIMMY");
		//courseRepository.addStudentToCours;
		Student student = new Student("LOng");
		Course course = new Course("English");
		studentRepository.insertStudentAndCourse(student, course);
		Course course2 = new Course("RimRaf");
		studentRepository.addCoursesToStudent(10003L, course2);
		Student student2 = new Student("Bob the builder");
		courseRepository.addStudentToCourse(10003L, student2);
	}
}
