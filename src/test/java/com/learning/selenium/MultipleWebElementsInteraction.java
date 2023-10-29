package com.learning.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWebElementsInteraction {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://form-bot-anvsystems.pages.dev/");
		//storing programming language from the form given by sir "https://form-bot-anvsystems.pages.dev/"
		List<WebElement> elements = driver.findElements(By.xpath("//form/label[7]/label"));
		for(int i=0; i<elements.size(); i++) {
			String elementText = elements.get(i).getText();
			if(elementText.contains("JavaScript")) {
				System.out.println("PASSED!");
				break;
			}
		}
		List<WebElement> countries = driver.findElements(By.xpath("//select[@name='country']/option"));
		for(WebElement el : countries) {
			System.out.println(el.getText());
		}
		driver.quit();
	}
}