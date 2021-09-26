package com.projects.registersystem.layout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.service.PersonService;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
public class PersonLayout extends VerticalLayout  {

	@Autowired 
	PersonService service;
	public PersonLayout() {
		addComponent(new Label("Below is the search result "));
	}
	
	public void setPersons(List<Person> persons){
		
		removeAllComponents();
		for(Person person: persons) {
			addComponent(new PersonItemLayout(person));
		}
		
	}
}
