package com.salesForce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class LoginVerification extends SeleniumBase {
	public LoginVerification() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(how = How.LINK_TEXT, using = "Log In")
	private WebElement login;
	public LoginVerification clickLoginNavigation() {
		click(login);
		return this;
	}
	
	@FindBy(how = How.ID,using = "username")
	private WebElement userName;
	public LoginVerification enterUserName(String str) {
		clearAndType(userName, str);
		return this;
	}
	
	@FindBy(how = How.ID,using = "password")
	private WebElement password;
	public LoginVerification enterPassword(String str) {
		clearAndType(password, str);
		return this;
	}
	@FindBy(how = How.ID,using = "Login")
	private WebElement Login;
	public LoginVerification clickLogin() {
		click(Login);
		return this;
	}
}
