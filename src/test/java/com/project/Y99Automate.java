package com.project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Y99Automate {
	
//	Create a method to send message:
	public static void sendMessage(WebDriver driver, String receivedMessage) throws InterruptedException {
		// Send 1st message
        WebElement msgField = driver.findElement(By.xpath("//textarea[@class='chatinput input-flex-item private']"));
        	 
            msgField.sendKeys(receivedMessage);
            driver.findElement(By.xpath("//i[@class='icon send material-icons private-send-button']")).click();
	}
	
//	public static void sendMessage(WebDriver driver) throws InterruptedException {
		// Send 1st message
//        WebElement msgField = driver.findElement(By.xpath("//textarea[@class='chatinput input-flex-item private']"));
//        	 
//            msgField.sendKeys("M of F?");
//            driver.findElement(By.xpath("//i[@class='icon send material-icons private-send-button']")).click();
//	}
	
//	Create a method check is chat ended and start new chat:
	public static void startNewChat(WebDriver driver) throws InterruptedException {
		// Check if chat ended
        boolean chatEnded = !driver.findElements(By.xpath("//span[contains(text(),'Tap')]")).isEmpty();

        if (chatEnded) {
            // Click new chat
            WebElement newChat = driver.findElement(By.xpath("//button[contains(text(),'New chat')]"));
            newChat.click();
            Thread.sleep(2000);
        }
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		 // Path to Brave browser
        String bravePath = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"; // adjust as needed

        // Set the path to chromedriver executable (must match Brave's version)
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe"); // replace with your actual path

        // Set ChromeOptions to use Brave
        ChromeOptions options = new ChromeOptions();
        options.setBinary(bravePath);

		
		WebDriver driver = new ChromeDriver(options);
		
//		Implicit Wait:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		==============================================================================
//		Login Starts
//		==============================================================================
		
//		Open y99 login page
		driver.get("https://y99.in/web/login");
		
//		Maximize window:
		driver.manage().window().maximize();
//		
		driver.findElement(By.xpath("//div[@class='blue--text login-instead']")).click();
		
//		Get username feild:
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Your username']"));
		username.sendKeys("Sahil112312");
		
//		Get Password feild:
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Your password']"));
		password.sendKeys("test12345");
		
		driver.switchTo().frame("iframe-login");
		
//		Locate continue button
		WebElement continueBtn = driver.findElement(By.xpath("//button[normalize-space(text())='CONTINUE']"));
		
//		Clicking continue button:
		continueBtn.click();
		
//		Switch from ifram to default or main page:
		driver.switchTo().defaultContent();
		
//		==============================================================================
//		Login Ends
//		==============================================================================
		
		
//		==============================================================================
//		Go to Chat Starts
//		==============================================================================
		
//		Locate go to chat button
		WebElement chatLink = driver.findElement(By.className("a-btn"));
		
//		Click on go to chat button:
		chatLink.click();
		
//		==============================================================================
//		Go to chat end
//		==============================================================================
		
//		==============================================================================
//		Nofitication Close Starts
//		==============================================================================
		
//		Click on no button:
		WebElement notification = driver.findElement(By.xpath("//div[normalize-space()='No']"));
		
//		Close the notification:
		notification.click();
		
//		=============================================================================
//		Notification close end
//		=============================================================================
		
//		=============================================================================
//		Select Chat Tab Start
//		Select chat person:
//		WebElement chatTab = driver.findElement(By.id("v-tour-step-0"));
//		System.out.println(chatTab.isDisplayed());
		
//		Click to chat:
//		chatTab.click();
		
//		=============================================================================
//		Select Chat Tab End
//		=============================================================================
		boolean hasRunOnce = false;
		while(true) {

			 try {
			        // Click chat tab (safe re-selection)
			        WebElement chatTab = driver.findElement(By.xpath(
			            "//a[contains(@class,'list__tile') and .//div[normalize-space()='Anonymous']] | //*[@id='v-tour-step-0']"
			        ));
			        if (chatTab.isDisplayed()) {
			            chatTab.click();
			        }
			        
//			        Receive Message:
//			        WebElement receivedMessage = driver.findElement(By.xpath("//div[contains(@class,'li-div message left')][last()]//div[@class='text']/span"));	
			     
			        
			        if(driver.findElement(By.xpath("//div[contains(@class,'li-div message left')][last()]//div[@class='text']/span")).isDisplayed()) {
//				        Reply to message:
				        sendMessage(driver, "I am Male");
			        }
			        
			        Thread.sleep(3000);

			        sendMessage(driver, "Adult chat?");
			        sendMessage(driver, "If you are female then add me......");
			        
//			        Click to send request:
			        WebElement sendRequestButton = driver.findElement(By.xpath("//div[contains(@class,'private-chat-container')]//button[3]//div[1]"));
			        if(sendRequestButton.isDisplayed()) {
			        	sendRequestButton.click();
			        	driver.findElement(By.xpath("//button[.//div[text()[normalize-space()='Continue']]]")).click();
			        	sendMessage(driver, "Add Me");
			        }

//			        Thread.sleep(5000);

//			        Start new chat if chat ended:
			        startNewChat(driver);
			        

			    } catch (org.openqa.selenium.StaleElementReferenceException e) {
			        System.out.println("Stale element, retrying...");
			    } catch (org.openqa.selenium.NoSuchElementException e) {
			        System.out.println("Element not found, retrying...");
			    } catch (Exception e) {
			        System.out.println("Unexpected error: " + e.getMessage());
			        break; // Exit the loop if unknown error
			    }
		}
		
	}
	
}
