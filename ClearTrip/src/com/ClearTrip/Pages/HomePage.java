package com.ClearTrip.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ClearTrip.CommonFunctions.BaseTest;


public class HomePage extends BaseTest{
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy (className ="pageTitle") WebElement PageHeader;
	
	// @FindBy (xpath= "//ul/li[4]/strong/span[2]") WebElement TotalPrice;
	
	@SuppressWarnings("static-access")
	public void validatePageHeader() throws IOException
	{
		VerifyText(PageHeader,read.getData("TestData", 1, 5));
			
	}
	//public String getTotalPrice() throws InterruptedException
	//{
	//	return getText(TotalPrice);
	//}
	public void capturePageScreenShot() throws IOException
	{
		takescreenShot();
		
	}
}
