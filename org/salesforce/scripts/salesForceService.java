package org.salesforce.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class salesForceService {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("bowyakarthikeyan@testleaf.com");
		driver.findElementById("password").sendKeys("Thiya2128");
		driver.findElementByCssSelector("input#Login").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		WebElement AppLaunch = driver.findElementByXPath("//p[text()='Service']");
		Actions builder = new Actions(driver);
		builder.moveToElement(AppLaunch).click().perform();
		builder.moveToElement(driver.findElementByXPath("//span[text()='Accounts']")).click().perform();
		driver.findElementByLinkText("New").click();
		driver.findElementByXPath("(//span[text()='Account Name'])[2]/following::input").sendKeys("Neduncheziyan");
		driver.findElementByXPath("(//span[text()='Phone'])[2]/following::input").sendKeys("9942961216");
		driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.stalenessOf(driver.findElementByCssSelector("a.slds-grid.slds-grid--vertical-align-center")));
		driver.findElementByCssSelector("a.slds-grid.slds-grid--vertical-align-center").click();
		builder.moveToElement(driver.findElementByLinkText("Submit for Approval")).click().perform();
		driver.findElementByCssSelector("textarea.inputTextArea").sendKeys("Closed");
		driver.findElementByXPath("//span[text()='Submit']").click();
		Thread.sleep(3000);
		String message = driver.findElementByCssSelector("div.detail.slds-text-align--center").getText();
		System.out.println(message);
		Assert.assertEquals(message, "No applicable approval process was found.");
		builder.moveToElement(driver.findElementByXPath("//span[text()='Close this window']")).click().perform();
	}

}
