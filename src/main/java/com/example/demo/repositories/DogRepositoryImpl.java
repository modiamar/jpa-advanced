package com.example.demo.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Dog;

@Repository
public class DogRepositoryImpl implements DogRepository {
	
	@PersistenceContext
	private EntityManager em;

	public DogRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Dog findById(Long id) {
		Dog dog = em.find(Dog.class, id);
		return dog;
	}

	@Override
	public Dog insert(Dog dog) {
		if(dog.getId() == null) {
			em.persist(dog);
		} else {
			em.merge(dog);
		}
		
		return dog;
	}

	@Override
	public void deleteById(Long id) {
		
	}

}
