package com.projects.registersystem.layout;

import com.projects.registersystem.entity.Person;
import com.projects.registersystem.service.PersonService;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class PersonItemLayout extends HorizontalLayout{
	
	public PersonItemLayout(Person person) {
		
		VerticalLayout layout = new VerticalLayout();
		Label id = new Label(person.getId().toString());
		Label name = new Label(person.getName());
		Label purpose = new Label(person.getPurpose());
		addComponents(id , name, purpose, new Label(person.getFlatNo()));
	}

}
