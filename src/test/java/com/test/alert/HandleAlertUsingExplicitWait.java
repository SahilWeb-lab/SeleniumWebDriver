package com.test.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
//		Explicit Wait:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
//		Get button and click on it: open normal alert
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		System.out.println("Alert Text : " + alert.getText());
		alert.accept();
	}

}
