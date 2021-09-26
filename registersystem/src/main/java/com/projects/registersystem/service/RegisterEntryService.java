package com.projects.registersystem.service;

import java.util.List;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.entity.RegisterEntry;


public interface RegisterEntryService {

	public void save(RegisterEntry entry);
	public void personEnter(Person person, String date);
	public void personLeave(Person person, String date);
	public List<Person> getPeopleByDate(String date);
	public List<Person> getVisitedPeople();
}
