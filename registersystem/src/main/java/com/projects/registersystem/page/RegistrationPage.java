package com.projects.registersystem.page;

import org.springframework.beans.factory.annotation.Autowired;

import com.projects.registersystem.ApplicationContextUtils;
import com.projects.registersystem.entity.Person;
import com.projects.registersystem.repository.PersonRepository;
import com.projects.registersystem.service.PersonService;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class RegistrationPage extends VerticalLayout implements View {
	
	public static final String NAME = "register";
	
	
	public PersonService service;
	
	public RegistrationPage(){
		service = ApplicationContextUtils.getApplicationContext().getBean(PersonService.class);
		addHeader();
		addform();
	}
	
	public void addHeader(){
		addComponent(new Label("Registration Page"));
	}
	
	public void addform() {
		VerticalLayout form = new VerticalLayout();
		
		VerticalLayout textFields = new VerticalLayout();
		HorizontalLayout buttons = new HorizontalLayout();
		
		TextField name = new TextField("Name");
		TextField flatNo = new TextField("FlatNo");
		TextField purpose = new TextField("Purpose");
		
		textFields.addComponents(name, flatNo, purpose);
		
		Button submit = new Button("Submit");
		submit.addClickListener(e -> {
			Person person = new Person();
			person.setName(name.getValue());
			person.setFlatNo(flatNo.getValue());
			person.setPurpose(purpose.getValue());
			
			
			Integer id = service.register(person);
			if(id>0) {
				addComponent(new Label("Registration successful! Your Id is "+id));  
				//Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
			}
			else {
				Notification.show("Bad User Info", Notification.Type.ERROR_MESSAGE);
			}
			
			
			
		});
		
		Button login = new Button("Login");
		login.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
			
		});
		buttons.addComponents(submit, login);

		form.addComponents(textFields,buttons);
		
		addComponent(form);
	}
}
