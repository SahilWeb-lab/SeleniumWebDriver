package com.test;

import java.io.File;
import java.time.Duration;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestCase {
	public static void main(String[] args) throws Exception {
		// Set up ChromeDriver path
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // ✅ Change this

		// Set path to Brave browser
		String bravePath = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"; // Adjust if
																										// needed

		// Set up ChromeOptions to use Brave
		ChromeOptions options = new ChromeOptions();
		options.setBinary(bravePath); // Point to Brave instead of Chrome

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://y99.in/web/login");

//    	Click to show login form:
		WebElement loginForm = driver.findElement(By.className("login-instead"));
		loginForm.click();

//    	Fill login details:
		WebElement usernameInput = driver.findElements(By.className("input-username")).get(0);
		usernameInput.sendKeys("Jackhill6");

		// 3. Fill password field (second input, has extra class 'mt-1')
		WebElement passwordInput = driver.findElements(By.className("input-username")).get(1);
		passwordInput.sendKeys("Jackhill6");

//          Press login button:
		WebElement loginIframe = driver.findElement(By.id("iframe-login"));
		loginIframe.click();

		System.out.println("Login Successfull!");
		waitSeconds();
		waitSeconds();
		closeAdds(driver);

//		Click btn to go to chat:
		WebElement chatButton = driver.findElements(By.cssSelector(".a-btn")).get(1);
		chatButton.click();
		waitSeconds();
		closeAdds(driver);

//         
		driver.findElement(By.xpath("//button[.//div[normalize-space()='No']]")).click();
		waitSeconds();
		closeAdds(driver);

//		Open chat:
		WebElement userTile = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[contains(@class, 'list-tile') and contains(@class, 'msg-node')]")));
		userTile.click(); // Or perform another action

		List<WebElement> messages = driver.findElements(By.cssSelector(".message.text_wrapper.text"));
		for (WebElement ele : messages) {
			System.out.println(ele.getText());
		}

		System.out.println("Program End....");
//        while (true) {
//            try {
//            	System.out.println("Loop is running....");
//                // Get latest message element (Update selector)
//                WebElement messageElem = driver.findElement(By.cssSelector(".chatinput"));
//                messageElem.sendKeys("M");
//                String message = messageElem.getText().trim().toUpperCase();
//
//                System.out.println("Received message: " + message);
//                
////                Get Send Button:
//                WebElement sendButton = driver.findElements(By.cssSelector(".inputbar .nosel")).get(3);
//                sendButton.click();
//
//                if (message.contains("F")) {
//                    System.out.println("🎯 Female detected! Playing alert...");
//                    playBeep(); // Play sound alert
//                } else if (message.contains("M")) {
//                    System.out.println("🚫 Male detected! Ending and restarting chat...");
//
//                    // Click End Chat (Update selector)
//                    WebElement endChatBtn = driver.findElement(By.id("endChatBtn")); // ✅ Change selector
//                    endChatBtn.click();
//
//                    Thread.sleep(1500); // Wait for transition
//
//                    // Click New Chat
//                    WebElement newChatBtn = driver.findElement(By.id("newChatBtn")); // ✅ Change selector
//                    newChatBtn.click();
//                }
//
//                Thread.sleep(2000); // Check again after delay
//
//            } catch (Exception e) {
//               
//            }
//        }
		// driver.quit(); // Uncomment if you plan to exit the loop
	}

	// Optional: Play a short beep or sound alert
	public static void playBeep() {
		java.awt.Toolkit.getDefaultToolkit().beep();
		// Or play a custom sound
		// playCustomSound("alert.wav");
	}

	// Optional method to play .wav file
	public static void playCustomSound(String filepath) {
		try {
			File soundFile = new File(filepath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (Exception e) {
			System.out.println("Error playing sound: " + e.getMessage());
		}
	}

//  Create a method to close adds:
	public static void closeAdds(WebDriver driver) {
//    Check is add on the screen or not:
		List<WebElement> elements = driver.findElements(By.className("pf-config-686cd37962e3a50148962597-close"));
		if (!elements.isEmpty()) {
			elements.stream().forEach(element -> element.click());
		}

		System.out.println("Ads Closed Method Running....");
	}

//  Create a method to wait for 10 seconds:
	public static void waitSeconds() throws InterruptedException {
		Thread.sleep(10000);
	}
}
