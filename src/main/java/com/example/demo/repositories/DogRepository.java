package com.example.demo.repositories;

import com.example.demo.domain.Dog;

public interface DogRepository {
 public Dog findById(Long id);
 public Dog insert(Dog dog);
 public void deleteById(Long id);
 
}
