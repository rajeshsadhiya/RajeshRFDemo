package com.selenium.project.seleniumDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RodenField2Test {


	//launch the firefox driver
	WebDriver driver=new FirefoxDriver();

	//creating the object RodenFieldPages
	RodenField2Pages pages=new RodenField2Pages(driver);

	@Test
	public void t2() throws Exception{

		// maximize the browser
		driver.manage().window().maximize();

		// setting timeout for implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//call URL in get method
		driver.get("https://www.rodanandfields.com/ca/");	

		pages.clickBecomeConsultant();
		pages.clickEnrollNow();
		pages.clickPolicyProcedureLink();
		pages.forFocusWindow();

		//verify the opened link is of Policies_Procedures
		Assert.assertTrue(pages.verifyPolicyProcedure(),"not verify the opened link is of Policies_Procedures");

		pages.forFocusBackWindow();       
		pages.enterSearchFieldName();
		pages.clickSearchButton();
		pages.clickFirstResultFromList();

		//verify the selected consultant's name appear on top left corner
		Assert.assertTrue(pages.verifyConsultantName(),"not verify the selected consultant's name appear on top left corner");

		pages.testPassScreenshot();
		driver.close();

	}
}
