package com.resolve.pom;

import com.resolve.generic.Waitstrategy;

public class LoginPage extends Basepage {
	
	
	
	private final String usernamelocator = "//input[@formcontrolname='username']";
	private final String passwordlocator = "//input[@formcontrolname='password']";
	
	
	public Inboxpage loginprocess(String userName,String password) throws InterruptedException {
		
		
		sendkeysAction(usernamelocator, "xpath", Waitstrategy.PRESENT, userName);
		
		sendkeysAction(passwordlocator, "xpath", Waitstrategy.PRESENT, password);
		Thread.sleep(10000);
		return new Inboxpage();
		
	}
	
	
	}


