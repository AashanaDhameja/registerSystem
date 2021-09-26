package com.projects.registersystem.page;

import java.util.List;

import com.projects.registersystem.ApplicationContextUtils;
import com.projects.registersystem.entity.Person;
import com.projects.registersystem.layout.PersonLayout;
import com.projects.registersystem.service.PersonService;
import com.projects.registersystem.service.RegisterEntryService;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class AdminPage extends VerticalLayout implements View{

	public static final String NAME = "admin";
	public RegisterEntryService service;
	PersonLayout personLayout;   
	
	public AdminPage() {
		service = ApplicationContextUtils.getApplicationContext().getBean(RegisterEntryService.class);
		personLayout = ApplicationContextUtils.getApplicationContext().getBean(PersonLayout.class);
		addform();
	}

	public void addform() {
		
		HorizontalLayout form = new HorizontalLayout();
		VerticalLayout func1 = new VerticalLayout();
		VerticalLayout func2 = new VerticalLayout();
		Label adreadyEnteredPeople = new Label("Click button to show all previously entered people");
		Button submit = new Button("Submit");
		submit.addClickListener(e -> {
			List<Person> visitors = service.getVisitedPeople();
			personLayout.setPersons(visitors);
			addComponent(personLayout);
		});
		
		func1.addComponents(adreadyEnteredPeople, submit);
		Label viewPeopleByDate = new Label("Click button to show records of particular date");
		TextField date = new TextField("Date");
		Button viewByDate = new Button("Submit");
		viewByDate.addClickListener(e -> {
			List<Person> persons = service.getPeopleByDate(date.getValue());
			personLayout.setPersons(persons);
			addComponent(personLayout);
		});
		
		func2.addComponents(viewPeopleByDate,date, viewByDate);
		
		form.addComponents(func1,func2);
		addComponent(form);
	}
}
