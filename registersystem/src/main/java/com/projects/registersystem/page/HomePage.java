package com.projects.registersystem.page;

import com.projects.registersystem.ApplicationContextUtils;
import com.projects.registersystem.entity.Person;
import com.projects.registersystem.entity.RegisterEntry;
import com.projects.registersystem.service.PersonService;
import com.projects.registersystem.service.RegisterEntryService;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class HomePage extends VerticalLayout implements View  {

	public static final String NAME= "home";
	public RegisterEntryService service;
	
	public HomePage() {
		service = ApplicationContextUtils.getApplicationContext().getBean(RegisterEntryService.class);
		addHeader();
		addForm();
	}
	
	public void addHeader() {
		addComponent(new Label("Please enter the type of Movement of the Visitor"));
	}
	
	public void addForm() {
		VerticalLayout form = new VerticalLayout();
		HorizontalLayout buttons = new HorizontalLayout();
		TextField date = new TextField("Date");
		Person currentPerson = (Person) VaadinSession.getCurrent().getAttribute("person");
		
		
		Button enter = new Button("Enter");
		enter.addClickListener(e -> {
			service.personEnter(currentPerson, date.getValue());
		});

		Button leave = new Button("Leave");
		leave.addClickListener(e -> {
			service.personLeave(currentPerson, date.getValue());
		});
		
		
		Button logout = new Button("Logout");
		logout.addClickListener(e-> {
			VaadinSession.getCurrent().setAttribute("person", null);
			getUI().getNavigator().removeView(HomePage.NAME);
			Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
			
		});
		
		buttons.addComponents(enter, leave, logout);
		form.addComponents(date,buttons );
		
		
		addComponent(form);
		
	}
	
}
