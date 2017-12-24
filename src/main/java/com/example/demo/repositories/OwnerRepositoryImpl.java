package com.example.demo.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Owner;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository{

	@PersistenceContext
	private EntityManager em;
	
	public OwnerRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Owner findById(Long id) {
		Owner owner = em.find(Owner.class, id);
		return owner;
	}

	@Override
	public Owner insert(Owner owner) {
		if (owner.getId() == null) {
			em.persist(owner);
		}else {
			em.merge(owner);
		}
		return owner;
	}

	@Override
	public void deleteById(Long id) {
		Owner owner = this.findById(id);
		em.remove(owner);
		
	}

	@Override
	public void bootstrapData() {
		//Bootstrap
		
	}

}
