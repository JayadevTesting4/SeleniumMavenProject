package com.testing.dataProvider;

//DataProvider is mapped with test
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DgataProviderDemo2 {
	@Test(dataProvider = "loginData2")
	public void loginWithCredentials(String userId, String password) throws InterruptedException {
		System.out.println("Login with user Id  "+userId);
		System.out.println("Login with password  "+password);
		
	}
	@DataProvider(name = "loginData2")
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
