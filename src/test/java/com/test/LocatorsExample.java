package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		boolean logoDisplayedStatus = driver.findElement(By.className("fb_logo")).isDisplayed();
		
		System.out.println("Logo is displayed : " + logoDisplayedStatus);
		
//		Name Selector:
		driver.findElement(By.id("email")).sendKeys("mrsahilmandal@gmail.com");
		
//		Link text & Partial Link Text selector:
//		driver.findElement(By.linkText("Forgotten password?")).click();
//		driver.findElement(By.partialLinkText("Forgotten")).click();
		
//		Tag name selector:
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		System.out.println("Total number of link tags : " + elements.size());
	}
	
} 
