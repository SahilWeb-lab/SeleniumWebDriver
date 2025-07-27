package com.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
//		Select specific checkbox:
//		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
//		Select all checkboxes:
//		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//		 for(WebElement checkbox : checkboxes) {
//			 checkbox.click();
//		 }
		
//		Select First three checkbox:
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for(int i = 0; i <= 3; i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		
//		Uncheck checkbox:
		for(WebElement checkbox : checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
			}
		}
		
	}
	
}
