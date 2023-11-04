package com.learning.selenium;

//ASSIGNMENT-"https://demo.guru99.com/payment-gateway/purchasetoy.php",
//open this site then fillup payment details
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PurchaseToy {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
//		driver.findElement(By.xpath("//nav[@id='nav']/a[2]")).click();
		Thread.sleep(1000);
		Select quantity = new Select(driver.findElement(By.name("quantity")));
		quantity.selectByVisibleText("5");
		driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("card_nmuber")).sendKeys("0192837465748392");
		Select month = new Select(driver.findElement(By.name("month")));
		month.selectByVisibleText("09");
		Select year = new Select(driver.findElement(By.name("year")));
		year.selectByVisibleText("2025");
		driver.findElement(By.id("cvv_code")).sendKeys("954");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}