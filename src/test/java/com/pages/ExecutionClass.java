package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExecutionClass {

	WebDriver driver;
	HomePage homePage;
	AddtoCart addtoCart;
	ExtentReport extentReport;
	Screenshots screenshot;
		
	
	@BeforeSuite
	public void setUpSuite() {
		extentReport = new ExtentReport();
		}
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"H:\\SeleniumJar\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/");
		homePage = new HomePage(driver);
		addtoCart = new AddtoCart(driver);
		screenshot = new Screenshots();
	}

	@Test(enabled = true, priority = 1)
	public void signupNew() throws InterruptedException {
		homePage.signupPage("jktest12@123", "Pass1245");
		extentReport.logPass("Singup successful");
	}

	@Test(enabled = true,priority = 2)
	public void login() throws InterruptedException {
		homePage.loginPage("jktest12@123", "Pass1245");
		Thread.sleep(10000);		
		Assert.assertTrue(driver.findElement(By.id("nameofuser")).isDisplayed());
		extentReport.logPass("Login successful");
	}

	@Test(enabled = true,priority = 3)
	public void checkout() throws InterruptedException {
		addtoCart.checkout("Test", "USA", "Newyork", "12345678", "12", "2025");
		Thread.sleep(10000);	
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).isDisplayed());
		extentReport.logPass("checkout successful");
	}

	@AfterMethod
	public void tearDown() {
		Screenshots.captureScreenshot(driver, "screen");
		driver.quit();
		
	}
	
	@AfterSuite
	public void tearDownDuite() {			
		extentReport.generateReport();
	}

}