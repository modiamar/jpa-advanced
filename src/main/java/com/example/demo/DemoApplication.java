package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Course;
import com.example.demo.repositories.CourseRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
		**/
		
	}
}
