package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class DownloadFile {
WebDriver driver;
File folder;

@BeforeMethod
public void setup() throws IOException {
    folder=new File(UUID.randomUUID().toString());
	folder.mkdir();
	System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
	driver=new ChromeDriver();
	String downloadFilepath = "..//SeleniumPractice//Driver";
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.default_directory", downloadFilepath);
    
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", chromePrefs);
    options.addArguments("--test-type");
    options.addArguments("--disable-extensions"); //to disable browser extension popup
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
}

@Test
public void downloadfile() throws Exception {
	driver.get("http://the-internet.herokuapp.com/download");
	driver.findElement(By.id("content")).click();
	Thread.sleep(4000);
	/*File listofFiles[]=folder.listFiles();
	Assert.assertequals(listofFiles.length, is(not(0)));
	for(File file:folder.listFiles()) {
		Assert.assertEquals(listofFiles.length, is(not((long))0)));*/
	}

@AfterMethod
public void teardown() {
    driver.quit();
	/*for(File file:folder.listFiles()) {
		file.delete();*/
	}
}

