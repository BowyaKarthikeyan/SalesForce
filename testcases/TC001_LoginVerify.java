package com.salesForce.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.salesForce.pages.LoginVerification;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TC001_LoginVerify extends ProjectSpecificMethods {
	
	@BeforeSuite
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Login Verification";
		author = "Bowya";
		category = "Smoke";
	}
	
	@Test
	public void login() {
		new LoginVerification()
		.enterUserName("bowyakarthikeyan@testleaf.com")
		.enterPassword("Thiya2128")
		.clickLogin();
	}

}
