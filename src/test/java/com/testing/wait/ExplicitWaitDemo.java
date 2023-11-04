package com.testing.wait;

//ExplicitlyWait is used for specific
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {

	@Test
	public void explicitWaitTest() {
		System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//selenium wait site
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(By.id("enable-button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("disable"))));
		driver.findElement(By.id("disable")).click();
		driver.quit();
	}
}