package com.project.table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTablePractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		
//		Get button and click on button:
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
//		Get button and click on button:
		driver.findElement(By.xpath("//tbody/tr[3]//input[@type='submit']")).click();
		
		String details[] = {"Rohan Raj", "Gali no. 2 chowk neta ji", "Pune", "Maharastra", "678906", "2142242778372343", "06", "2028", "John Doe"};
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='controls']/input[@type='text']"));
		int i = 0;
		for(WebElement e : elements) {
			e.clear();
			e.sendKeys(details[i]);
			i++;
		}
		
//		Select checkbox:
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		
//		Click on purchase ticket button:
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
//		Get Response Text after book:
		String reponse = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
		
		System.out.println("Response Message : " + reponse);
		
		
	}

}
