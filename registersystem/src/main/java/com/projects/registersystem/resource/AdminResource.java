package com.projects.registersystem.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.service.PersonService;
import com.projects.registersystem.service.RegisterEntryService;

@RestController
public class AdminResource {

	
	@Autowired
	RegisterEntryService registerEntryService;
	
	@Autowired
	PersonService personService;
	
	@PutMapping("enter/{person}/{date}")
	public String  personEnter(@PathVariable("person") String name, @PathVariable("date") String date) {
		Person person = personService.getPerson(name);
		return registerEntryService.personEnter(person, date);
	}
	
	@PutMapping("leave/{person}/{date}")
	public String personLeave(@PathVariable("person") String name, @PathVariable("date") String date) {
		Person person = personService.getPerson(name);
		return registerEntryService.personLeave(person, date);
	}
	
	@GetMapping("getPeopleByDate/{date}")
	public List<Person> getPeopleByDate( @PathVariable String date){
		return registerEntryService.getPeopleByDate(date);
	}
	
	@GetMapping("getVisitors")
	public List<Person> getVisitedPeople(){
		return registerEntryService.getVisitedPeople();
	}
}
