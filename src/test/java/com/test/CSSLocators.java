package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
//		Tag and Id combination:
//		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Hello World!");
//		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Test Word!");
	
//		Tag and Classname Combination:
//		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Class Example!");
//		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Test Example Something...");
		
//		Tag and attribute: tag[attribute='value']
//		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Sahil Mandal!");
		
//		Tag, class and attribute combination:
		driver.findElement(By.cssSelector("input.search-box-text[type='text']")).sendKeys("Mission Successful!");
		
	}
	
}
