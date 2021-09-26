package com.projects.registersystem.service;

import com.projects.registersystem.entity.Person;

public interface PersonService {
	
	public Integer save(Person person);
	public Person getPerson( String name );
	public Integer register(Person person);
	
	

}
