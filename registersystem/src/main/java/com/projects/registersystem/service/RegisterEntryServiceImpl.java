package com.projects.registersystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.entity.RegisterEntry;
import com.projects.registersystem.repository.PersonRepository;
import com.projects.registersystem.repository.RegisterRepository;
import com.vaadin.ui.Notification;

@Service
public class RegisterEntryServiceImpl implements RegisterEntryService{

	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Override
	public void save(RegisterEntry entry) {
		registerRepository.save(entry);
	}

	@Override
	public void personEnter(Person person, String date) {
		
		
		RegisterEntry entry = registerRepository.getRegisterEntryByVisitorId(person.getId());
		if(entry != null) {
			if(entry.getMovement().toLowerCase().equals("leave")) {
				entry.setMovement("Enter");
				entry.setDate(date);
				save(entry);
				//Add message to page
			}
			else {
				Notification.show("You are already inside the society.", Notification.Type.ERROR_MESSAGE);
			}
		}
		else {
			RegisterEntry newEntry = new RegisterEntry();
			newEntry.setVisitorId(person.getId());
			newEntry.setDate(date);
			newEntry.setMovement("Enter");
			save(newEntry);
			//Add message to page
		}
		
	}

	@Override
	public void personLeave(Person person, String date) {
		RegisterEntry entry = registerRepository.getRegisterEntryByVisitorId(person.getId());
		if(entry != null) {
			if(entry.getMovement().toLowerCase().equals("enter")) {
				entry.setDate(date);
				entry.setMovement("Leave");
				save(entry);
				//Add message to page
			}
			else {
				Notification.show("You have already left the society", Notification.Type.ERROR_MESSAGE);
			}
		}
		else {
			Notification.show("You cannot leave society without entering.", Notification.Type.ERROR_MESSAGE);
		}
		
	}

	@Override
	public List<Person> getPeopleByDate(String date) {
		List<RegisterEntry> entries = (List<RegisterEntry>) registerRepository.getRegisterEntryByDate(date);
		List<Person> persons = personRepository.findAll();
		List<Person> visitors = new ArrayList<Person>();
		for(RegisterEntry entry : entries) {
			for(Person person: persons) {
				if(person.getId() == entry.getVisitorId()) {
					System.out.println("Id--> "+entry.getVisitorId());
					visitors.add(person);
					break;
				}
			}
		}
		return visitors;
	}

	@Override
	public List<Person> getVisitedPeople() {
		List<RegisterEntry>entries = registerRepository.findAll();
		List<Person> persons = personRepository.findAll();
		List<Person> visitors = new ArrayList<Person>();
		for(RegisterEntry entry : entries) {
			for(Person person: persons) {
				if(person.getId() == entry.getVisitorId()) {
					System.out.println("VisitorId--> "+entry.getVisitorId());
					visitors.add(person);
					break;
				}
			}
		}
		return visitors;
	}
	
}
