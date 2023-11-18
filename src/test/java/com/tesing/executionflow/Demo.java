package com.tesing.executionflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Demo {
	@Test
	public void addItemToCartTest() throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/payment-gateway/index.php");
		Select quantity = new Select(driver.findElement(By.name("quantity")));
		quantity.selectByVisibleText("2");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(4000);
		driver.quit();
	}
	@Test
	public void checkoutTest() {
		System.out.println("Checkout Step!");//created statement false for
											//better understaood
		
	}

}
