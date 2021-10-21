package com.amazon.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import newCart.BaseClass;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/amazon/feature",
				glue="com/amazon/stepdefinition", plugin="pretty", monochrome = true)

public class TestRunner {

	public static WebDriver driver;
	
	@BeforeClass
	
	public static void setup() {
		driver = BaseClass.browserLaunch("chrome");
	}	
}