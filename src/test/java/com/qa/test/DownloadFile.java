package com.qa.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class DownloadFile {
WebDriver driver;
File folder;

@BeforeMethod
public void setup() {
    folder=new File(UUID.randomUUID().toString());
	folder.mkdir();
	System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
	driver=new ChromeDriver();
	
	Map <String, Object> prefs=new HashMap <String, Object>();
	prefs.put("profile.default_content_settings.popups", "0");
	prefs.put("download.default_directory",folder.getAbsolutePath());
	
	/*options.setExperimentalOption("prefs", prefs);
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(ChromeOptions.CAPABILITY, options);*/
}

@Test
public void downloadfile() {
	driver.get("http://the-internet.herokuapp.com/download");
	driver.findElement(By.xpath("//*[@id='content']/div/a[1])")).click();
}

@AfterMethod
public void teardown() {
	driver.quit();
	for(File file:folder.listFiles())
}
}
