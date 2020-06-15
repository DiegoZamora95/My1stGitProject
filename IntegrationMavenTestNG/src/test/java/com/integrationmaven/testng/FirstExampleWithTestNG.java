package com.integrationmaven.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class FirstExampleWithTestNG {
	
	WebDriver driver;
	By searchBoxLocator = By.name("q");
	By androidLinkResult = By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div[2]/div/div/span[1]/a");

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@Test
	public void searchAndroidInfo() {
		WebElement searchbox = driver.findElement(searchBoxLocator);
		searchbox.clear();
		searchbox.sendKeys("android studio");
		searchbox.submit();
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.presenceOfElementLocated(androidLinkResult));
		
		System.out.println("This is result number:" + driver.findElement(androidLinkResult).getText());
		
		assertTrue(driver.findElement(androidLinkResult).isDisplayed(), "Ther result number is not present");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
