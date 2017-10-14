package com.ClearTrip.Pages;

import java.util.Dictionary;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ClearTrip.CommonFunctions.BaseTest;

public class SearchResultDetailPage extends BaseTest{
	
	public String flight;
	public String date;
	public String time;
	public String amount;
	@SuppressWarnings("rawtypes")
	public Dictionary dict;
	public SearchResultDetailPage (WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy (xpath = "//*[@id= 'itinBlock']/div/div/div[1]/h1") WebElement flightDetailTest;
	@FindBy (xpath = "//*[@id='itinBlock']/div/div/div[1]/h1/small[2]") WebElement dateText;
	@FindBy (xpath =  "//*[@id = 'itinBlock']/div/div/div[1]/h1/small[3]") WebElement timeText;
	@FindBy (id= "itineraryBtn") WebElement continueButton;
	@FindBy (id = "counter") WebElement flightAmount;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getDetailsFromResultDetailPage() throws InterruptedException
	{
		dict = new Hashtable();
		flight = getText(flightDetailTest).substring(0,17);
		System.out.println(flight);
	
		System.out.println(flight.length());
		date = getText(dateText);
		time = getText(timeText);
		amount = getText(flightAmount);
		
		dict.put("flightdetail",flight);
		dict.put("dateText", date);
		dict.put("timeText",time);
		dict.put("flightAmount", amount);
		
	}
	
	public HomePage clickOnContinueBooking()
	
	{
		click(continueButton);
		return PageFactory.initElements(driver,HomePage.class);
	}
	
	}

