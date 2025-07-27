package com.project.frames;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlFrameExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
//		Frame 1:
		WebElement frame = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Sahil!");
		
//		Go back to main page:
		driver.switchTo().defaultContent();
		
//		Frame 2:
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Work....");
		
//		Go back to main page:
		driver.switchTo().defaultContent();
		
		
//		Frame 3: inside antoher frame also:
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Dancing...");
		
//		Go to inner frame:
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//div[@class='YEVVod']//span[text()='I am a human']"));
		element.click();
		
//		Go back to main page:
		driver.switchTo().defaultContent();		
		
		
//		Frame 5: 
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("this is dummy...");
		
//		Click on the url inside 5th frame:
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		driver.switchTo().defaultContent();
		
//		Open Frame 5: Logo Selection
		WebElement opendedframe5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(opendedframe5);
		boolean displayed = driver.findElement(By.xpath("//a[@id='logo']")).isDisplayed();
		
		System.out.println("Logo Displayed : " + displayed);
		driver.findElement(By.xpath("//div[@class='box-section']//div[@class='btn btn-primary button-download']")).click();
		
//		Go back to main page:
		driver.switchTo().defaultContent();
		
	}

}
