package com.projects.registersystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.service.PersonService;

@RestController
public class PersonResource {

	@Autowired 
	PersonService service;
		
	@GetMapping("person/{name}")
	public Person getPerson(@PathVariable String name ) {
		return service.getPerson(name);
	}
	
	@PostMapping("register")
	public  Integer register(@RequestBody Person person) {
		 return service.register(person);
	}

}
