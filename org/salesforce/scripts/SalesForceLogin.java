package org.salesforce.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SalesForceLogin {
	public static void main(String[] args) throws InterruptedException {

//			String userProfile= "C:\\Users\\dell\\AppData\\Local\\Google\\Chrome\\User Data\\";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//	        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\chromedriver.exe");
//	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--user-data-dir="+userProfile);
//	        options.addArguments("--profile-directory=Default");
//	        options.addArguments("--start-maximized");

		ChromeDriver driver = new ChromeDriver();
//	        driver.get("https://mail.google.com/mail/u/0/#inbox");

		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("bowyakarthikeyan@testleaf.com");
		driver.findElementById("password").sendKeys("Thiya2128");
		driver.findElementByCssSelector("input#Login").click();

		Thread.sleep(8000);

		driver.findElementByXPath("//*[name()='svg' and @data-key='add']").click();

		WebElement newEvent = driver.findElementByXPath("//span[text()='New Event']");

		Actions builder = new Actions(driver);
		builder.click(newEvent).perform();

		driver.findElementByXPath("//label[text()='Subject']/..//input").sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);

		driver.findElementByXPath("(//span[text()='Save'])[2]").click();

	}

}
