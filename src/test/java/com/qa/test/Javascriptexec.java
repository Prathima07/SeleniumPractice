package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Javascriptexec {
WebDriver driver;
@BeforeMethod
public void setup(){
	System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
	driver=new ChromeDriver();
	driver.get("http://the-internet.herokuapp.com/javascript_alerts");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
}
@Test
public void javascrpt() throws Exception {
	driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
}
@AfterMethod
public void teardown() {
	driver.quit();
}
}
