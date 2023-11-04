package com.exel.selenium;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader1 {
	public static void main(String[] args) throws IOException {
			FileInputStream fis = new FileInputStream(new File("./data/testdata.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
//			String data = sheet.getRow(1).getCell(2).getStringCellValue();
//			System.out.println(data);
			int lastRowNumber = sheet.getLastRowNum();
//			System.out.println(lastRowNumber);
			for(int i=0; i<=lastRowNumber; i++) {
				XSSFRow row = sheet.getRow(i);
				int lastCellNumber = row.getLastCellNum();
//				System.out.println(lastCellNumber);
				for(int j=0; j<lastCellNumber; j++) {
					XSSFCell cell = row.getCell(j);
					System.out.println(cell.getStringCellValue());
				}
			}
	}
}