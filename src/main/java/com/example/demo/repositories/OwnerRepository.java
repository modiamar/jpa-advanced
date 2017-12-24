package com.example.demo.repositories;

import com.example.demo.domain.Owner;

public interface OwnerRepository  {

	public Owner findById(Long id);

	public Owner insert(Owner owner);


	public void deleteById(Long id);


	public void bootstrapData();

	
}
