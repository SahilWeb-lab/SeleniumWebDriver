package com.test.navigational.commands;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
	
		Set<String> windowHandles = driver.getWindowHandles();

//		Approach 1:
		List<String> windowIds = new ArrayList<>(windowHandles);
//		String parentWindow = windowIds.get(0);
//		String childWindow = windowIds.get(1);
//		
////		Switch to child window:
//		driver.switchTo().window(childWindow);
//		System.out.println(driver.getTitle());
//		
////		Switch to parent window:
//		driver.switchTo().window(parentWindow);
//		System.out.println(driver.getTitle());
		
//		Appraoch 2:
		for(String windowId : windowIds) {
			@Nullable
			String title = driver.switchTo().window(windowId).getTitle();
			if(title.equals("OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
			}
		}
		
	}
	
}
