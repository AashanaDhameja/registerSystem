package com.projects.registersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public Integer save(Person person) {
		Person p = personRepository.save(person);
		return p.getId() ;
	}

	@Override
	public Integer register(Person person) {
		if(person.getName().isEmpty() || person.getFlatNo().isEmpty() || person.getPurpose().isEmpty())
			return 0;
		
		Person existingPerson = personRepository.getPersonByName(person.getName());
		if(existingPerson != null) 
			return 0;
		
		return save(person);
	}
	
	@Override
	public Person getPerson( String name) {
		Person person =  personRepository.getPersonByName(name);
		if(person.getName().equals(name))
			return person;
		else
			return null;
	}
	
	

}
