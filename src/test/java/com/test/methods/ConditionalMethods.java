package com.test.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();
		
//		==============================================================================
//		isDisplayed:
//		==============================================================================
		boolean displayed = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Logo Displayed : " + displayed);
		
//		===============================================================================
//		isEnabled:
//		===============================================================================
		boolean enabled = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("First Name Feild is Enabled : " + enabled);
		
//		===============================================================================
//		isSelected:
//		===============================================================================
		WebElement maleSelected = driver.findElement(By.id("gender-male"));
		WebElement femaleSelected = driver.findElement(By.id("gender-female"));
		System.out.println("Before Selection.....");
		System.out.println("Male Selected : " + maleSelected.isSelected());
		System.out.println("Female Selected : " + femaleSelected.isSelected());
		
		System.out.println("After Selecting male radio button......");
		maleSelected.click();
		System.out.println("Male Selected : " + maleSelected.isSelected());
		System.out.println("Female Selected : " + femaleSelected.isSelected());
		
		System.out.println("After Selecting female radio button......");
		femaleSelected.click();
		System.out.println("Male Selected : " + maleSelected.isSelected());
		System.out.println("Female Selected : " + femaleSelected.isSelected());
		
		System.out.println("Newsletter selection....");
		WebElement newsLetter = driver.findElement(By.id("Newsletter"));
		System.out.println("NewsLetter Selected : " + newsLetter.isSelected());
		newsLetter.click();
		System.out.println("After dis selecting");
		System.out.println("NewsLetter Selected : " + newsLetter.isSelected());
		
	}
	
}
