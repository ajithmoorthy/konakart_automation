package com.atmecs.konakart.helper;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.atmecs.konakart.extentreport.Extent;
import com.atmecs.konakart.logreports.LogReporter;
import com.relevantcodes.extentreports.LogStatus;

public class ValidaterHelper extends Extent{
	LogReporter log=new LogReporter();
	ActionHelper helper=new ActionHelper(); 
	//this method will check the url is correct or not
	public void correctUrlChecker(WebDriver Driver,String Expected_Url){
		try {
			Assert.assertEquals(Driver.getCurrentUrl(),Expected_Url);
			log.logReportMessage("Successfully Validated the correct Url is :"+ Driver.getCurrentUrl());
			logger.log(LogStatus.INFO,"Successfully Validated the correct Url is :" +Driver.getCurrentUrl());
		}catch(AssertionError e) {
			System.out.println("Navigate to wrong Webpage");
			log.logReportMessage("Navigate to wrong Webpage");
			logger.log(LogStatus.INFO, "Navigate to wrong Webpage");
		}	
	}
	//this method validate the page document title
	public void validateTitle(WebDriver driver, String documentTitle){
		try {
			Assert.assertEquals(driver.getTitle(), documentTitle);
			log.logReportMessage("Document title is validated :"+driver.getTitle());
			logger.log(LogStatus.INFO,"Document title is validated :" +driver.getTitle());
		}
		catch(AssertionError e)
		{
			System.out.println("Document title is not match with Expected :"+driver.getTitle());
			log.logReportMessage("Document title is not match with Expected :"+driver.getTitle());
			logger.log(LogStatus.INFO,"Document title is not match with Expected :"+driver.getTitle());	
		}
	}
	//this method will return the inner text of the web elements
	public String webElementgetText(WebDriver webdriver,String locator) {
		WebElement element=webdriver.findElement(By.xpath(locator));
		String content=element.getText();
		return content;
	}
	public void validateElements(WebDriver driver,String locators,String[] footerarray) {
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locators)));
		List<WebElement> list=driver.findElements(By.xpath(locators));
		int count=0;
		while(count<1) {
			for(WebElement element:list)
			{
				String[] elementarray=element.getText().split("\n");
				for(int variable=0; variable<elementarray.length; variable++) {
					assertValidate(elementarray[variable],footerarray[count]);
					count++;
				}
			}
		}
	}
	/**
	 * Aseertvalidate is used to validate the actual and expected values is correct or not. 
	 * @param actual
	 * @param expected
	 */
	public void assertValidate(String actual,String expected) {
		try {
			Assert.assertEquals(actual,expected);
			log.logReportMessage("Actual Value :"+actual+" and Expected :"+expected+" is validated succesfully");
			logger.log(LogStatus.INFO,"Actual Value :"+actual+" and Expected :"+expected+" is validated succesfully");	
		}
		catch(AssertionError e)
		{
			System.out.println("Actual Value :"+actual+" not match wiht the Expected value :"+expected);
			log.logReportMessage("Actual Value :"+actual+" not match wiht the Expected value :"+expected);
			logger.log(LogStatus.INFO,"Actual Value :"+actual+" not match wiht the Expected value :"+expected);
		}

	}
	public void validateProduct(WebDriver driver,String locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);
			List<WebElement> foo = wait.until(new Function<WebDriver, List<WebElement>>() 
			{
			  public List<WebElement> apply(WebDriver driver) {
			  return driver.findElements(By.xpath(locator));
			}
			});
			int count=0;
		while(count<foo.size()) {
			for(WebElement element:foo)
			{
				System.out.println(element.getText());
					count++;
			}
		}
	}
}

