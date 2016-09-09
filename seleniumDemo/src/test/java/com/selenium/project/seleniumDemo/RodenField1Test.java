package com.selenium.project.seleniumDemo;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RodenField1Test {

	//launch the firefox driver
	WebDriver driver=new FirefoxDriver();

	//creating the object RodenFieldPages
	RodenField1Pages pages=new RodenField1Pages(driver);

	@Test
	public void t1() throws Exception{

		// maximize the browser
		driver.manage().window().maximize();

		// setting timeout for implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//call URL in get method
		driver.get("https://www.rodanandfields.com/ca/");
		
		pages.clickShopSkinCare();
		pages.clickAllProducts();
		Thread.sleep(2000);
		
		//Verify the user is on quickshop page
		Assert.assertTrue(pages.verifyQuickShop(), "not Verify the user is on quickshop page");

		pages.clickRefineByProducts();
		
		pages.selectRefineByRedefineFromDropDown();
		pages.clickRefineByProducts();
		
		pages.selectRedefineByReverseFromDropDown();
		
		pages.clickRefineByPrice();
		
		pages.selectRedefineByPriceCadFromDropDown();

		//Verify the Redefine filter labels along with checkbox on the page
        Assert.assertTrue(pages.verifyRedefineLabelWithCheckbox(),"not Verify the Redefine");
		
		//Verify the Reverse filter labels along with checkbox on the page	
		Assert.assertTrue(pages.verifyReverseLabelWithCheckbox(),"not Verify the Reverse");

		//Verify the products listed now have price in the range of selected price filter
		Assert.assertTrue(pages.verifyProductPrice(), "not verify the selected consultant's name appear on top left corner");
		
		pages.testPassScreenshot();
   
		driver.quit();
	}

}
