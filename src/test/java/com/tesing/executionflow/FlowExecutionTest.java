package com.tesing.executionflow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlowExecutionTest {

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am before Test");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am beforeMethod");
	}

	@Test
	public void test1() {
		System.out.println("I am test1");
	}

	@Test
	public void test2() {
		System.out.println("I am test2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am afterMethod");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am after Test");
	}
}