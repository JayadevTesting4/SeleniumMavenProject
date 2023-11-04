package com.testing.first;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void compareTest() {
		String name = "Sid";
		Assert.assertEquals("Sid", name);
	}
}