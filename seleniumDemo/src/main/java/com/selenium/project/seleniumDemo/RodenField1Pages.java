package com.selenium.project.seleniumDemo;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class RodenField1Pages {


	WebDriver driver;

	By shopSkinCare=By.xpath("//*[contains(text(),'SHOP SKINCARE')]");
	By allProducts=By.xpath("//*[contains(text(),'All Products')]");
	By refineByProducts=By.className("refine-products-button");
	By refineByRedefine=By.xpath("//div[contains(text(),'REDEFINE')]/following-sibling::div/div");
	By refineByReverse=By.xpath("//div[contains(text(),'REVERSE')]/following-sibling::div/div");
	By refineByPrice=By.xpath("//input[@class='refine-products-button' and @value='- Price -']");
	By refineByPriceCad=By.xpath("//div[contains(text(),'CAD$50 TO CAD$199.99')]/following-sibling::div/div");

	//verifying redefine, reverse & price
	By verifyRedefine=By.xpath("//div[@id='quick-filtered']/ul[2]/li[1]/form");
	By verifyReverse=By.xpath("//div[@id='quick-filtered']/ul[2]/li[2]/form");
	By verifyPrice=By.xpath("//p[@class='prices']/span");




	public RodenField1Pages(WebDriver driver){
		this.driver=driver;
	}

	public void clickShopSkinCare(){
		driver.findElement(shopSkinCare).click();
	}

	public void clickAllProducts(){
		driver.findElement(allProducts).click();
	}

	public void clickRefineByProducts(){
		driver.findElement(refineByProducts).click();

	}

	public void selectRefineByRedefineFromDropDown(){
		driver.findElement(refineByRedefine).click();

	}

	public void selectRedefineByReverseFromDropDown(){
		driver.findElement(refineByReverse).click();

	}

	public void clickRefineByPrice(){
		driver.findElement(refineByPrice).click();

	}

	public void selectRedefineByPriceCadFromDropDown(){
		driver.findElement(refineByPriceCad).click();
	}


	public boolean verifyQuickShop(){
		return driver.getCurrentUrl().contains("quickShop");
	}

	//verifyRedefine behaviour
	public boolean verifyRedefineLabelWithCheckbox(){
		return driver.findElement(verifyRedefine).getText().contains("REDEFINE");
	}

	//verifyReverse behaviour

	public boolean verifyReverseLabelWithCheckbox(){
		return driver.findElement(verifyReverse).getText().contains("REVERSE");
	}

	//verifyPrice behaviour 
	public boolean verifyProductPrice(){
		return driver.findElement(verifyPrice).getText().contains("CAD$");
	}

	public void testPassScreenshot() throws Exception{
		File sFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sFile, new File("D:/Selenium_Shubham/screenshot1.jpg"));
	}

}
