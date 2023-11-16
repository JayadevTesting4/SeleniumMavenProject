package com.tesing.dataProvider.excel.datadriven;

//data of exel sheet will put as userId and password in "https://demo.guru99.com/v1/index.php"
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

public class LoginTest {
	@Test(dataProvider = "loginData3")
	public void loginWithCredentials(String userId, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v1/index.php");
		driver.findElement(By.name("uid")).sendKeys(userId);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "GTPL Bank Manager HomePage");
		driver.quit();
	}
	@DataProvider(name = "loginData3")
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
