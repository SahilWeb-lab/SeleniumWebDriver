package com.test.methods;

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(5000);
		
//		==============================================================================
//		Get Methods:
//		==============================================================================
//		Get Webpage Title
		@Nullable
		String title = driver.getTitle();
		
		System.out.println("WebPage Title : " + title);
		
//		Get Current URL:
		System.out.println("Current URL : " + driver.getCurrentUrl());
		
//		Get Page Source:
		System.out.println("Page Source:");
		System.out.println(driver.getPageSource());
		
//		Get Window ID
		System.out.println("Window ID : " + driver.getWindowHandle());
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Window IDs : " + windowHandles);
		
	}
	
}
