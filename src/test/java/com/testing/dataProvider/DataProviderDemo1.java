package com.testing.dataProvider;

//DataProvider is mapped with test

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {
	@Test(dataProvider = "loginData1")
	public void loginWithCredentials(String userId, String password) throws InterruptedException {
		System.out.println("Login with user Id  "+userId);
		System.out.println("Login with password  "+password);
		
	}
	@DataProvider(name = "loginData1")
	public Object[][] loginDataProvider(){
		return new Object[][] {
			{"abc","def"},
			{"pqr","ghi"}
		};
	}
	

}
