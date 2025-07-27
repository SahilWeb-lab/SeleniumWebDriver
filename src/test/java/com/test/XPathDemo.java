package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://y99.in/web/login");
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
//		XPath with single attribute:
//		driver.findElement(By.xpath("//input[@placeholder='Example - Hannah1990']")).sendKeys("Hello Sahil!");
		
//		XPath with multiple attribute:
//		driver.findElement(By.xpath("//input[@class='input-username'][@placeholder='Example - Hannah1990']")).sendKeys("Test_USER");
		
//		XPath with and operator:
//		driver.findElement(By.xpath("//input[@class='input-username' and @placeholder='Example - Hannah1990']")).sendKeys("testing");
		
//		XPath with or operator:
//		driver.findElement(By.xpath("//input[@class='input-username' or @placeholder='Example - Hannah199']")).sendKeys("testing");
		
//		Thread.sleep(5000);
//		Xpath with innerText:
//		boolean displayed = driver.findElement(By.xpath("//div[text()='Y99 Chat']")).isDisplayed();
//		System.out.println(displayed);
		
//		Xpath with contains:
//		driver.findElement(By.xpath("//input[contains(@placeholder,'Example')]")).sendKeys("Test Search!");
		
//		Xpath with starts-with:
//		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Exa')]")).sendKeys("Hello4353");
		
		
//		Handling Dynamic Attributes: (Start And Stop State)
		//*[@id='Start' or @id='Stop']
		//*[contains(@id,'St')]
		//*[starts-with(@id, 'St')]
		
		
//		Chained Xpath: Absoulte Path + Relative Path
		boolean isLogoDisplayed = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		
		System.out.println(isLogoDisplayed);
		
	}
	
}
