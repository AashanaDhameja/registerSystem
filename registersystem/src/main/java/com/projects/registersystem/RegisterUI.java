package com.projects.registersystem;
import com.projects.registersystem.page.HomePage;
import com.projects.registersystem.page.LoginPage;
import com.projects.registersystem.page.RegistrationPage;
import com.projects.registersystem.page.LoginPage;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI
public class RegisterUI extends UI{

	@Override
	protected void init(VaadinRequest request) {
		new Navigator(this,this);
		getNavigator().addView(LoginPage.NAME, LoginPage.class);
		getNavigator().addView(RegistrationPage.NAME, RegistrationPage.class);
		
		Page.getCurrent().addPopStateListener(e -> {
			route(e.getUri());
		});
		
		route("");
		//setContent(new Label("Login Page"));
		
	}
	
	public void route(String uri) {
		if(VaadinSession.getCurrent().getAttribute("person")!= null) {
			getUI().getNavigator().addView(HomePage.NAME, HomePage.class);
			Page.getCurrent().setUriFragment("!"+HomePage.NAME);
		}
		else {
			getNavigator().navigateTo(LoginPage.NAME);
		}
	}

}
