package com.test.navigational.commands;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
	
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String window : windowHandles) {
			@Nullable
			String title = driver.switchTo().window(window).getTitle();
			System.out.println(title);
			
			if(title.equals("Human Resources Management Software | OrangeHRM HR Software")) { 
				driver.close();
				System.out.println("Child window closed successfully!");
			}
		}
		
	}
	
}
