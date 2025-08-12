package com.project.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		//# Locate the select element
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
			
//		Create Select Object:
		Select select = new Select(dropdown);
		
//		Select By Visible Text:
//		select.selectByVisibleText("Germany");
		
//		Select By index:
//		select.selectByIndex(5);
		
//		Select By value:
//		select.selectByValue("china");
		
//		Get all the options from select:
		List<WebElement> options = select.getOptions();
		System.out.println("Total no of options : " + options.size());
		
		for(WebElement element : options) {
			System.out.println(element.getText());
		}
		
	}

}
