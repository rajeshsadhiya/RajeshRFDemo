package com.selenium.project.seleniumDemo;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RodenField2Pages {

	WebDriver driver;
	String parentwin;

	By becomeConsultant=By.xpath("//*[contains(text(),'BECOME A CONSULTANT')]");
	By enrollNow=By.xpath("//*[contains(text(),'Enroll Now')]");
	By policyProcedures=By.xpath("//div[@class='content']/p/a[1]");
	By enterSearchField=By.xpath("//input[@id='sponserparam']");
	By searchButton=By.xpath("//*[contains(text(),'SEARCH')]");
	By clickFirstResult=By.xpath("//div[@id='search-results']/div/div[1]/form/div");

	//verify consultant name
	By verifyName=By.xpath("//div[@id='sponsorInfo']/div[1]/a");

	public RodenField2Pages(WebDriver driver){
		this.driver=driver;
	}

	public void clickBecomeConsultant(){
		driver.findElement(becomeConsultant).click();
	}


	public void clickEnrollNow(){
		driver.findElement(enrollNow).click();
	}


	public void clickPolicyProcedureLink(){
		driver.findElement(policyProcedures).click();
	}

	public void enterSearchFieldName(){
		driver.findElement(enterSearchField).sendKeys("test");
	}

	public void clickSearchButton(){
		driver.findElement(searchButton).click();
	}

	public void clickFirstResultFromList(){
		driver.findElement(clickFirstResult).click();
	}

	public void forFocusWindow(){

		//focus another window
		parentwin = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for (String s : allwin) {
			if (s.equals(parentwin) == false) {
				driver.switchTo().window(s);

			}
		}

	}

	//verify Policies Procedures
	public boolean verifyPolicyProcedure(){
		return driver.getCurrentUrl().contains("Policies_Procedures_CANADA.pdf");
	}

	public void forFocusBackWindow(){	
		driver.close();
		driver.switchTo().window(parentwin);
	}

	//verify consultant name
	public boolean verifyConsultantName(){
		return driver.findElement(verifyName).getText().contains("Michael Brand");	

	}

	public void testPassScreenshot() throws Exception{
		File sFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sFile, new File("D:/Selenium_Shubham/screenshot2.jpg"));
	}
}