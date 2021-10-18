package com.projects.registersystem.service;

import java.util.List;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.entity.RegisterEntry;


public interface RegisterEntryService {

	public void save(RegisterEntry entry);
	public String personEnter(Person person, String date);
	public String personLeave(Person person, String date);
	public List<Person> getPeopleByDate(String date);
	public List<Person> getVisitedPeople();
}
