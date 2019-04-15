package com.smokeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailMsgReader {
	WebDriver driver;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
	}

	@BeforeMethod
	public void pageLoad() throws InterruptedException {
		//driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("suraj9391");
		driver.findElement(By.xpath("//content[@class='CwaK9']//span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ilikeshiher");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac' and contains(text(), 'Next')]")).click();
		//System.out.println(driver.getTitle());
	}

	@Test
	public void select_email()  {
		
		System.out.println(driver.getTitle());
		boolean b =  driver.findElement(By.xpath("//span[starts-with(text(),'OTP')]")).isDisplayed();
		System.out.println(b);
		 List <WebElement> sub =
		 driver.findElements(By.xpath("//span[starts-with(text(),'OTP')]"));
        //System.out.println(sub.size());
		// System.out.println(sub.get(1).getText());
		 sub.get(1).click();
		// System.out.println(sub.get(1).isDisplayed());
String otp = driver.findElement(By.xpath("//p[@dir= 'ltr']")).getText();
System.out.println(otp);
Pattern p = Pattern.compile("\"([^\"]*)\"");
Matcher m = p.matcher(otp);
while (m.find()) {
  System.out.println(m.group(1));
}

	}
}
