package com.learning.selenium;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class FormBot {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://form-bot-anvsystems.pages.dev/");
		//for 5 time entering this form by loop
//		for(int i=0; i<5; i++) {
//			driver.findElement(By.name("firstname")).sendKeys(UUID.randomUUID().toString().substring( (int) 0.8));
//			driver.findElement(By.name("lastname")).sendKeys(UUID.randomUUID().toString().substring( (int) 0.8));
//			driver.findElement(By.name("email")).sendKeys(UUID.randomUUID().toString().substring((int) 0.8)+"@test.com");
//			driver.findElement(By.name("gender")).click();
//			driver.findElement(By.name("phone")).sendKeys(UUID.randomUUID().toString().substring(0,10));
//			Select s = new Select(driver.findElement(By.name("country")));
//			s.selectByVisibleText("India");
//			driver.findElement(By.name("programming")).click();
//			driver.findElement(By.tagName("button")).click();
//		
//		}
		driver.findElement(By.name("firstname")).sendKeys(UUID.randomUUID().toString().substring( (int) 0.8));
		driver.findElement(By.name("lastname")).sendKeys(UUID.randomUUID().toString().substring( (int) 0.8));
		driver.findElement(By.name("email")).sendKeys(UUID.randomUUID().toString().substring((int) 0.8)+"@test.com");
		driver.findElement(By.xpath("/html/body/div/div/form/label[4]/label[2]")).click(); //ABSOLUTE XPATH - NOT RECOMENDED WAY
		driver.findElement(By.name("phone")).sendKeys(UUID.randomUUID().toString().substring(0,10));
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@value='JavaScript']")).click(); //RELATIVE XPATH - RECOMENDED WAY
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
