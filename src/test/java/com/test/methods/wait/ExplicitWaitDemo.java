package com.test.methods.wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		// Explicit wait:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // declaration
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		loginBtn.click();
	}
	
}
