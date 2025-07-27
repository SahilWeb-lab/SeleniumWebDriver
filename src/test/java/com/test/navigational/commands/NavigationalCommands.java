package com.test.navigational.commands;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://demo.nopcommerce.com/"); // Get method accepts url only in string format.
		
//		driver.navigate().to("https://demo.nopcommerce.com/");	// Navigate method accepts url in both string and URL object format
		
//		URL url = new URL("https://demo.nopcommerce.com/");
//		driver.navigate().to(url);

		
		driver.navigate().to("https://demo.nopcommerce.com/");
		System.out.println("First Opened : " + driver.getCurrentUrl());
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Second Opened : " + driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println("Back URL : " + driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println("Forward URL : " + driver.getCurrentUrl());
		
		driver.navigate().refresh();
	}
	
}
