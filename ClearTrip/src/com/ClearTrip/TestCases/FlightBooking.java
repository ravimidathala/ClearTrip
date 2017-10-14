package com.ClearTrip.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.ClearTrip.BrowserFactory.BrowserFactory;
import com.ClearTrip.CommonFunctions.BaseTest;
import com.ClearTrip.Pages.HomePage;
import com.ClearTrip.Pages.SearchPage;
import com.ClearTrip.Pages.SearchResultDetailPage;
import com.ClearTrip.Pages.SearchResultsPage;

public class FlightBooking extends BaseTest{

	@BeforeTest
	public void Before()
	{
		System.out.println("######################################################");
		System.out.println("################# Test case Started################### ");
	}
	
	@Test (description = "Flight booking test case")
	public void flightBooking () throws InterruptedException, IOException
	{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://www.cleartrip.com");
		
		SearchPage search = PageFactory.initElements(driver, SearchPage.class);
		search.enterDataOnSearchPage();
		SearchResultsPage results = search.clickOnSearchButton();
		SearchResultDetailPage resultDetail = results.clickOnBookButton();
		resultDetail.getDetailsFromResultDetailPage();
		System.out.println("Source and Destination are " + resultDetail.dict.get("flightdetail"));
		System.out.println("Journey Date is "+ resultDetail.dict.get("dateText"));
		System.out.println("Journey Time is " + resultDetail.dict.get("timeText"));
		System.out.println("Total Price displayed is " + resultDetail.dict.get("flightAmount"));
		HomePage itenaryPage = resultDetail.clickOnContinueBooking();
		itenaryPage.validatePageHeader();
		itenaryPage.capturePageScreenShot();
		//System.out.println("Total Price displayed is " + itenaryPage.getTotalPrice());
		
		System.out.println("###########################################################");
		driver.quit();
	}
	
}
