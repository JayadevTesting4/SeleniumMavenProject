package com.tesing.dataProvider.excel.datadriven;

//data of exel sheet will put as userId and password in "https://demo.guru99.com/v1/index.php"
//code optimization of LoginTest.java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest1 {

	public WebDriver driver;

	public void setupBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
			driver = new ChromeDriver();
		}
		//FOR OTHER BROWSERS USE else if()...
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public void type(By locatorType, String typeText) {
		driver.findElement(locatorType).sendKeys(typeText);
	}

	public void clickElement(By locatorType) {
		driver.findElement(locatorType).click();
	}

	@Test(dataProvider = "loginData4")
	public void loginWithCredentials(String userId, String password) throws InterruptedException {
		setupBrowser("chrome");
		navigate("https://demo.guru99.com/v1/index.php");
		type(By.name("uid"), userId);
		type(By.name("password"), password);
		clickElement(By.name("btnLogin"));
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");
		driver.quit();
	}

	@DataProvider(name = "loginData4")
	public Object[][] loginDataProvider() throws IOException {
			FileInputStream fis = new FileInputStream(new File("./data/data1.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("LoginData");
			int lastRowNumber = sheet.getLastRowNum();
			int lastCellNumber = sheet.getRow(0).getLastCellNum();
			String[][] loginData = new String[lastRowNumber][lastCellNumber];
			for(int i=1; i<=lastRowNumber; i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0; j<lastCellNumber; j++) {
					XSSFCell cell = row.getCell(j);
					loginData[i-1][j] = cell.getStringCellValue();
				}
			}	
			return loginData;
		}

}