package com.ClearTrip.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import com.ClearTrip.CommonFunctions.BaseTest;

public class SearchResultsPage extends BaseTest {

	public SearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy (xpath = "//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[1]/table/tbody/tr[2]/td[3]/button") WebElement bookButton;
	
	public SearchResultDetailPage clickOnBookButton () throws IOException
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(bookButton);
		return PageFactory.initElements(driver, SearchResultDetailPage.class);
		
	}
	
	
}
