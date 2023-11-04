package com.exel.selenium;
// DOUT-OUTPUT DO NOT SHOW, WHAT IS THE PROBLEM DO NOT RECOGNISES....
//warning shows in below :-
//Build path specifies execution environment JavaSE-1.7. 
//There are no JREs installed in the workspace that are strictly compatible with this environment. 	
//SeleniumMavenProject		Build path	JRE System Library Problem
//The compiler compliance specified is 1.7 but a JRE 20 is used	SeleniumMavenProject		
//Compiler Compliance	JRE Compiler Compliance Problem

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream(new File("./data/testdata.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			String data = sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}