package com.ClearTrip.CommonFunctions;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public ExcelReader read = new ExcelReader();
	
	public String screenShotFile;
	
	/**********************************************************************
	 * Function to click WebElement
	 * @param e
	 */
	public void click(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOf(e));
		e.click();
	}
	/**********************************************************************
	 * Function to clear and type in WebElement
	 * @param e
	 */
	public void clearAndType(WebElement e, String data)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(e));
		Thread.sleep(1000);
		e.clear();
		e.sendKeys(data);
	}
	
	/**********************************************************************
	 * Function to clear and type in WebElement
	 * @param e
	 */
	
	public void type(WebElement e, String data)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(e));
		Thread.sleep(500);
		e.sendKeys(data);
		
	}
	/**********************************************************************
	 * Function to get text from a WebElement
	 * @param e
	 * @throws InterruptedException 
	 */
	public String getText(WebElement e) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(e));
		Thread.sleep(1000);
		return e.getText();
		
	}
	/**********************************************************************
	 * Function to quit browser
	 * 
	 *  @param e 
	 */
	public void closeDriver()
	{
		driver.quit();
		System.out.println("Browser Session is Closed");
	}
	
	/***********************************************************************
	 * Validations
	 */
	public Boolean VerifyText (WebElement e, String expectedTextKey)
	{
		String actualText = e.getText().trim();
		
		if(actualText.equals(expectedTextKey.trim()))
		{
			System.out.println("Text Verification Success. Text is " +actualText );
			return true;
			
		}
		else
		{
			Assert.fail("Text Verification Failure. ActualText is"+ actualText + " And the expected Text is: " + expectedTextKey);
			return false;
		}
	}
	
	public void takescreenShot() throws IOException
	{
		// filename of the screen shot
		Date d = new Date();
		System.out.println(d);
		String screenShotFile = d.toString().replace(":","_").replace(" ","_")+".png";
		System.out.println(screenShotFile);
		
		// StoreScreenshot file
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs (OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File ( "D://"+screenShotFile));
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
}


