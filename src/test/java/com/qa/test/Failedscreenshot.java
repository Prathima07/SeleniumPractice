package com.qa.test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class Failedscreenshot {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPractice//Driver//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.expedia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testScreenshots() throws Exception {
		driver.findElement(By.id("package-origin-hp-packagewuieruw")).sendKeys("refdf");
        //Give Invalid element
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// Create reference of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our
				// project home directory and
				// result.getName() will return name of test case so that screenshot name will
				// be same
				FileUtils.copyFile(source, new File("..//SeleniumPractice//Screenshot//" + result.getName() + ".png"));

				System.out.println("Screenshot taken");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}
}
