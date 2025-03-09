package com.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	static WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how = How.ID, using= "login2")
	private WebElement login;
	
	@FindBy(how = How.ID, using= "signin2")
	private WebElement signup;
	
	@FindBy(how = How.ID, using= "loginusername")
	private WebElement userName;
	
	@FindBy(how = How.ID, using="loginpassword")
	private WebElement pass;
	
	@FindBy(xpath ="//button[@type='button' and contains(., 'Log in')]")
	private WebElement loginButton;
	
	@FindBy(how = How.ID, using= "sign-username")
	private WebElement signupname;
	
	@FindBy(how = How.ID, using= "sign-password")
	private WebElement Signuppass;
	
	@FindBy(xpath ="//button[@type='button' and contains(., 'Sign up')]")
	private WebElement signupButton;
	
	
	public WebElement getLogin() {
		return this.login;
	}

	public WebElement getSignup() {
		return this.signup;
	}

	public WebElement getUserName() {
		return this.userName;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLoginButton() {
		return this.loginButton;
	}

	public WebElement getSignupname() {
		return this.signupname;
	}

	public WebElement getSignuppass() {
		return this.Signuppass;
	}

	public WebElement getSignupButton() {
		return this.signupButton;
	}

	public void signupPage(String UN, String Pass) throws InterruptedException

	{
		getSignup().click();
		Thread.sleep(10000);
		getSignupname().sendKeys(UN);
		getSignuppass().sendKeys(Pass);
		getSignupButton().click();
		Thread.sleep(12000);
		Alert a = driver.switchTo().alert();
		System.out.print("alert text="+a.getText());
		a.accept();

	}

	public void loginPage(String UN, String Pass) throws InterruptedException {
		getLogin().click();
		Thread.sleep(10000);		
		getUserName().sendKeys(UN);
		getPass().sendKeys(Pass);
		getLoginButton().click();	

	}

}