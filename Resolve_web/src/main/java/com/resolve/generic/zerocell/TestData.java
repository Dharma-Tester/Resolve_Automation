package com.resolve.generic.zerocell;

import com.creditdatamw.zerocell.annotation.Column;
import com.google.inject.PrivateBinder;

public class TestData {
	
	
	
	@Column(name = "TestCase" , index = 0)
	private String TestCase;
	
	@Column(name = "Browser" , index = 1)
	private String Browser;
	
	@Column(name = "Browser" , index = 2)
	private String Region;
	
	@Column(name = "Browser" , index = 3)
	private String Username;
	
	@Column(name = "Browser" , index = 4)
	private String Password;

	@Override
	public String toString() {
		return "TestData [TestCase=" + TestCase + ", Browser=" + Browser + ", Region=" + Region + ", Username="
				+ Username + ", Password=" + Password + "]";
	}

	public String getTestCase() {
		return TestCase;
	}

	public String getBrowser() {
		return Browser;
	}

	public String getRegion() {
		return Region;
	}

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}


	
}
