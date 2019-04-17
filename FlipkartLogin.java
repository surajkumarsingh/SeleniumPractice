package com.flipkart.funtionalTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartLogin {
	static WebDriver driver;
	WebDriver driver2;
	GmailMsgReader mail;
	String otp;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass
	public void setUP() {
		driver = new ChromeDriver();

		capabilities.setCapability("noReset", "true");

	}

	@BeforeMethod
	public void pageLoad() throws InterruptedException {
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		// Thread.sleep(2000);
		System.out.println("BeforeMethod");
	}

	@Test(priority = 0)
	public static void Login() throws Exception {
		driver.get("http://www.flipkart.com");
		// driver.findElement(By.xpath("//a[contains(text(), 'Login &
		// Signup')]")).click();
		driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys("suraj9391@gmail.com");
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='Km0IJL col col-3-5']//*"));

		if (elements.size() == 25) {
			// System.out.println(elements.get(i).getTagName());
			System.out.println(elements.get(22).getText());
			elements.get(22).click();

		}

		else if ((elements.size() != 25)) {
			driver.quit();
			new FlipkartLogin().setUP();
			FlipkartLogin.Login();
		}
	}
//		try {
//			// driver.findElement(By.xpath("//button//span[contains(text(),
//			// CONTINUE)]")).click();
//			Thread.sleep(2000);
//			// driver.findElement(By.xpath("//button[contains(text(), 'Login with
//			// OTP')]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[contains(text(), 'Request OTP')]")).click();
//
//		} catch (Exception e) {
//
//			e.printStackTrace();}

	@Test(priority = 1)
	public void gmail_login_Otp() throws InterruptedException {
		driver2 = new ChromeDriver();
		driver2.get("https://www.gmail.com");
		driver2.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("suraj9391");
		driver2.findElement(By.xpath("//content[@class='CwaK9']//span")).click();
		Thread.sleep(2000);
		driver2.findElement(By.xpath("//input[@type='password']")).sendKeys("ilikeshiher");
		driver2.findElement(By.xpath("//span[@class='RveJvd snByac' and contains(text(), 'Next')]")).click();
		System.out.println("Glogin");
		Thread.sleep(2000);
		System.out.println(driver2.getTitle());
	}

	@Test(priority = 2)
	public void select_email() throws InterruptedException {

		System.out.println(driver2.getTitle());
		List<WebElement> sub = driver2.findElements(By.xpath("//span[starts-with(text(), 'Flipkart Account')]"));

		System.out.println(sub.size());

		sub.get(1).click();

		Thread.sleep(2000);
		 otp = driver2.findElement(By.xpath("//td//br//preceding::strong")).getText();
		System.out.println(otp);
		System.out.println(otp.length());
		for (int i = 0; i < otp.length(); i++) {
			System.out.print(otp.charAt(i));
		}
	}

	@Test(priority = 3)
	public void fill_Otp() {
		String s = null;
	System.out.println(driver.getTitle());
	
		List<WebElement> otpl = driver.findElements(By.xpath("//div[@class='_1jvRms']//input"));
		System.out.println(otpl.size());
					
		for (int i = 0; i < otpl.size(); i++) {
				
				System.out.print(otp.charAt(i));
				
				char c = otp.charAt(i);
				
				 s = String.valueOf(c);	
				 otpl.get(i).sendKeys(s);
			}
	}
}
