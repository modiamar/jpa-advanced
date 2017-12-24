package com.example.demo.repositories;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Dog;
import com.example.demo.domain.Owner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerRepositoryImplTest {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Transactional
	public void testOneToOneMapping() {
		Owner owner = ownerRepository.findById(10003L);
		System.out.println(owner);
		Dog dog = owner.getDog();
		System.out.println(dog);
	}
	
	@Test
	@Transactional
	public void testOneToOneMappingBackwards() {
		Dog dog = entityManager.find(Dog.class, 10004L);
		System.out.println(dog.getOwner());
		
	}

}
