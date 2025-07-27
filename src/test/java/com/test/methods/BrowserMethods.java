package com.test.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		WebElement element = driver.findElement(By.linkText("OrangeHRM, Inc"));
		element.click();
		
		Thread.sleep(5000);
//		driver.close();	 // Close Single Browser Window
		driver.quit();	// Close all the browser window
	}
	
}
