package org.salesforce.scripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomApp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("bowyakarthikeyan@testleaf.com");
		driver.findElementById("password").sendKeys("Thiya2128");
		driver.findElementByCssSelector("input#Login").click();
		Thread.sleep(3000);
		driver.findElementByLinkText("Object Manager").click();
		driver.findElementByXPath("(//span[text()='Create'])[2]").click();
		driver.findElementByLinkText("Custom Object").click();
//		WebElement fr = driver.findElementByXPath("//iframe");
		driver.switchTo().frame(driver.findElementByXPath("//iframe"));
		Thread.sleep(3000);
//		wait.until(ExpectedConditions.(driver.findElementByXPath("//table[@class='detailList']/tbody//td[2]//input")));
		driver.findElementByXPath("//table[@class='detailList']/tbody//td[2]//input").sendKeys("Food Product");
		driver.findElementById("PluralLabel").sendKeys("Food Products");
		Select dataType = new Select(driver.findElementById("AutoNo"));
		dataType.selectByVisibleText("Auto Number");
		driver.findElementById("NameAutoNumberMask").sendKeys("A-{0000}");
		driver.findElementById("StartingNo").sendKeys("1");
		driver.findElementByXPath("(//table[@class='detailList'])[3]//tr/td/input").click();
		driver.findElementByXPath("(//table[@class='detailList'])[3]//tr[2]/td/input").click();
		driver.findElementByXPath("(//table[@class='detailList'])[3]//tr[3]/td/input").click();
		driver.findElementByXPath("(//table[@class='detailList'])[6]//td/input[1]").click();
		driver.findElementByXPath("(//table[@class='detailList'])[7]//tr/td/input[1]").click();
		driver.findElementByXPath("(//table[@class='detailList'])[7]//tr[2]/td/input").click();
		driver.findElementByXPath("//table//td[@class='pbButtonb']/input").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElementByXPath("//iframe"));
		Select object = new Select(driver.findElementByXPath("//table//tr[3]//Select"));
		object.selectByVisibleText("Food Product");
		driver.findElementByCssSelector("[id='ep']").click();
		Set<String> window = driver.getWindowHandles();
		
		
	}

}
