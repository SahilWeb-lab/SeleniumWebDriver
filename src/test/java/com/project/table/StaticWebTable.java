package com.project.table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//		Find total number of rows in table:
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("Total number of rows : " + totalRows.size());
		
		System.out.println();
		
//		Find total number of columns in table:
		List<WebElement> totalColumns = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th"));
		System.out.println("Total number of columns : " + totalColumns.size());
		
		System.out.println();
		
//		Read data from specific row and column:
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[4]")).getText();
		System.out.println("Data : " + data);
		
		System.out.println();
		
//		Read all data from table
		for(int row = 1; row <= totalRows.size(); row++) {
			for(int col = 1; col <= totalColumns.size(); col++) {
				
//				For table head:
				if(row == 1) {
					String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ row +"]//th["+ col +"]")).getText();
					System.out.print(value + "\t");
					continue;
				}
				
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ row +"]//td["+ col +"]")).getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
//		Print book name whose author is mukesh:
		for(int i = 2; i <= totalRows.size(); i++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ i +"]//td["+ 2 +"]")).getText();
			
			if(author.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ i +"]//td[1]")).getText();
				
				System.out.println(bookName + "\t" + author);
			}
			
		}
		
		System.out.println();
		
//		Find total price of all the books:
		int totalPrice = 0;
		for(int r = 2; r <= totalRows.size(); r++) {
			String bookPrice = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+ r +"]//td[4]")).getText();
			totalPrice += Integer.parseInt(bookPrice);
		}
		
		System.out.println("Total Price : " + totalPrice);
	}

}
