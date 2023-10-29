package com.learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UIDemoProvideBySirAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v2/");
		driver.findElement(By.name("uid")).sendKeys("mngr26593");
		driver.findElement(By.name("password")).sendKeys("1234567@");
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(1000);
		driver.quit();
	}
}