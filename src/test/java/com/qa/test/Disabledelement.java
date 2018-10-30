package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Disabledelement {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","..//SeleniumPractice//Driver//chromedriver" );
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dropdown");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
/*	@Test
	public void isenabled() throws InterruptedException {
		WebElement drop=driver.findElement(By.id("dropdown"));
		Select sel=new Select(drop);
		sel.selectByVisibleText("Option 1");
		
		Boolean b = driver.findElement(By.xpath("//*[@id='dropdown']/option[1]")).isEnabled();
		System.out.println(b);
		Boolean b1 = driver.findElement(By.xpath("//*[@id='dropdown']/option[1]")).isDisplayed();
		b.booleanValue();
		System.out.println(b1);
		Thread.sleep(2000);
	}*/
	//*[@id="dropdown"]/option[1]
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        assertThat(dropdown.getOptions().get(0).isEnabled(), is(false));
    }

}




