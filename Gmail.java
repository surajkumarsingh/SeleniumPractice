package com.smokeTest;

import java.net.MalformedURLException;
import java.net.URL;
import com.smokeTest.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import testBase.TestBase;

public class Gmail extends TestBase {
	DesiredCapabilities capabilities = new DesiredCapabilities();   
	WebElement element;
	GmailMsgReader Otpreader;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("appPackage", "com.google.android.gm");
		capabilities.setCapability("noReset", "true");
		//capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("appActivity", "com.google.android.gm.GmailActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		}
		@Test
		
		public void sendEmail() {
	
			driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.google.android.gm:id/compose_button']")).click();
			
			
			driver.findElement(By.xpath("//android.widget.MultiAutoCompleteTextView[@resource-id='com.google.android.gm:id/to']")).sendKeys("suraj9391@gmail.com");
			
		    driver.findElement(By.xpath("//android.widget.MultiAutoCompleteTextView[@resource-id='com.google.android.gm:id/to']")).click();
			
			driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.google.android.gm:id/subject']")).sendKeys("OTP");
			
			driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.google.android.gm:id/body']")).sendKeys("This is the OTP \"567677\"" );
			
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.gm:id/send']")).click();
			
		}
	
}
