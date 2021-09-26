package com.projects.registersystem.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.registersystem.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	public Person getPersonByName(String name);
	public List<Person> findAll();
	
}
