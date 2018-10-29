package com.qa.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkbox {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
		driver=new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
				
	}
    @Test
    public void checkbox() throws Exception {
   /*WebElement check=driver.findElement(By.id("bmwcheck"));
    	check.click();
    	Thread.sleep(2000);
    	WebElement check1=driver.findElement(By.id("hondacheck"));
    	check1.click();*/
   List<WebElement> check=driver.findElements(By.xpath("//fieldset/label/input[@type='checkbox']"));
    	for(WebElement allcheck:check) {
    		allcheck.click();
    		Thread.sleep(2600);
    	}
    	
    	////*[@id="checkbox-example"]/fieldset
    }
    @AfterMethod
    public void teardown() {
    	driver.quit();
    }
}
