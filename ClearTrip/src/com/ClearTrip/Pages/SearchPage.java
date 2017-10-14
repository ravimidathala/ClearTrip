package com.ClearTrip.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ClearTrip.CommonFunctions.BaseTest;
import com.ClearTrip.CommonFunctions.ExcelReader;

public class SearchPage extends BaseTest{
	
	public SearchPage (WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	@FindBy (id ="FromTag") WebElement From_xpath;
	@FindBy (id ="ToTag") WebElement To_xpath;
	@FindBy (id = "DepartDate") WebElement DepartDate_xpath;
	@FindBy (id = "Childrens" ) WebElement Childrens_id;
	@FindBy (id = "SearchBtn") WebElement SearchBtn_id;
	@FindBy (id = "Adults") WebElement Adults_id;
	
	@SuppressWarnings("static-access")
	public void enterDataOnSearchPage () throws InterruptedException, IOException
	{
		ExcelReader read = new ExcelReader();
		System.out.println(read.getData("TestData",1,1));
		clearAndType (From_xpath, read.getData("TestData", 1, 0));
		clearAndType (To_xpath, read.getData("TestData", 1, 1));
		clearAndType (DepartDate_xpath, read.getData("TestData", 1, 4));
		type (Adults_id, read.getData("TestData", 1, 2));
		type (Childrens_id, read.getData("TestData", 1, 3));
		
	}
	public SearchResultsPage clickOnSearchButton()
	{
		click(SearchBtn_id);
		return PageFactory.initElements(driver,SearchResultsPage.class);
	}
	

} 
