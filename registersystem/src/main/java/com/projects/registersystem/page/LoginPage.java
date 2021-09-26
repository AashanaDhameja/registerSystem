package com.projects.registersystem.page;

import com.projects.registersystem.ApplicationContextUtils;
import com.projects.registersystem.entity.Person;
import com.projects.registersystem.service.PersonService;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginPage extends VerticalLayout implements View {
	
	public static final String NAME = "login";
	public PersonService service;
	
	
	public LoginPage(){
		service = ApplicationContextUtils.getApplicationContext().getBean(PersonService.class);
		addHeader();
		addForm();
		adminPanel();
	}
	
	public void addHeader(){
		addComponent(new Label("Login Page"));
	}
	
	public void addForm() {
		VerticalLayout form = new VerticalLayout();
		
		VerticalLayout textFields = new VerticalLayout();
		HorizontalLayout buttons = new HorizontalLayout();
		
		TextField id = new TextField("ID");
		TextField name = new TextField("Name");
		
		textFields.addComponents(id, name);
		
		
		
		Button submit = new Button("Submit");
		submit.addClickListener(e -> {
			
			if(id.isEmpty()) {
				Notification.show("Please enter your ID.", Notification.Type.ERROR_MESSAGE);
			}
			else {
			Person person = new Person();
			person.setId(new Integer(id.getValue()));
			person.setName(name.getValue());  
			
			
			
			Person gottenPerson = service.getPerson(person.getName());
			
			if(validate(person, gottenPerson)) {
				VaadinSession.getCurrent().setAttribute("person", gottenPerson);
				getUI().getNavigator().addView(HomePage.NAME, HomePage.class);
				Page.getCurrent().setUriFragment("!"+HomePage.NAME);
			}
			else {
				Notification.show("Please enter your correct ID.", Notification.Type.ERROR_MESSAGE);
			}}
			
		});
		
		Button register = new Button("Register");
		register.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!"+RegistrationPage.NAME);
			
		});
		
		
		buttons.addComponents(submit, register);

		form.addComponents(textFields,buttons);
		
		addComponent(form);
		
	}
	
	public void adminPanel() {
		VerticalLayout form = new VerticalLayout();
		Label label = new Label("Enter password for entering in Admin Panel");
		TextField password = new TextField("Password");
		
		Button submit = new Button("Submit");
		submit.addClickListener(e -> {
			if(password.getValue().equals("12345")) {
				getUI().getNavigator().addView(AdminPage.NAME, AdminPage.class);
				Page.getCurrent().setUriFragment("!"+AdminPage.NAME);
			}
			else {
				Notification.show("Wrong Admin Password.", Notification.Type.ERROR_MESSAGE);
			}
		});
		form.addComponents(label,password,submit);
		
		addComponent(form);
	}
	
	private boolean validate(Person person,Person gottenPerson) {
		
		if(gottenPerson == null || !gottenPerson.getId().equals(person.getId()))
			return false;
		else
			return true;
	}
}  
