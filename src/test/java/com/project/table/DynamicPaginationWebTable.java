package com.project.table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		int totalRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
		int totalPages = Integer.parseInt(driver.findElement(By.xpath("//ul[@id='pagination']//li[last()]//a")).getText());
		
		for(int p = 1; p <= totalPages; p++) {
			if(p > 1) {
				WebElement activePage = driver.findElement(By.xpath("//ul[@id='pagination']//li["+ p +"]//a"));
				activePage.click();
				Thread.sleep(3000);
			}
			
//			Reading data from page:
			int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			
			for(int i = 1; i <= rows; i++) {
				WebElement id = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+ i +"]//td[1]"));
				WebElement name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+ i +"]//td[2]"));
				WebElement price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+ i +"]//td[3]"));
				System.out.print(id.getText() + "\t" + name.getText() + "\t" + price.getText());
				System.out.println();
				
//				Get checkbox:
				WebElement checkbox = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+ i +"]//td[4]//input"));
				if(!checkbox.isSelected()) {
					checkbox.click();
				}
				
			}
			System.out.println("---------------------------------------------------");
		}
		
	}

}
