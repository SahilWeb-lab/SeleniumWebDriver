package com.test.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
//		Get button and click on it: open normal alert
//		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
//		Normal Alert
//		=================================================
//		Get alert:
//		Alert alert = driver.switchTo().alert();
		
//		Thread.sleep(3000);
		
//		Accept Alert:
//		alert.accept();
//		======================================================
		
//		Confirm Alert:
//		=======================================================
//		Click to open confirm alert:
//		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//		
//		Alert alert = driver.switchTo().alert();
//		System.out.println("Alert Text : " + alert.getText());
//		
//		Thread.sleep(3000);
//		
////		Accept Alert:
////		alert.accept();
//		
////		Dismiss or cancel alert:
//		alert.dismiss();
		
//		============================================================
		
//		Prompt Alert:
//		============================================================
//		Click to open confirm alert:
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello Sahil Mandal");
		System.out.println("Alert Text : " + alert.getText());
		Thread.sleep(3000);
		
//		alert.accept();
		alert.dismiss();
	}
	
}
