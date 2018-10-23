package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClick {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
	driver=new ChromeDriver();
	
	driver.get("https://learn.letskodeit.com/p/practice");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);	
	}
    @Test
    public void test() throws Exception {
    	Actions action=new Actions(driver);
    	WebElement search=driver.findElement(By.id("opentab")); 
    	action.contextClick(search).perform();
    	action.sendKeys(Keys.ARROW_DOWN).build().perform();
    	 action.sendKeys(Keys.ARROW_DOWN).build().perform();
    	 action.sendKeys(Keys.ARROW_DOWN).build().perform();
    	 action.sendKeys(Keys.ENTER).build().perform();
    	Thread.sleep(3000);
    }
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
	
	
}
