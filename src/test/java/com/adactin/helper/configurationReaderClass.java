package com.adactin.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configurationReaderClass {
	
	public static Properties p;
	
	public configurationReaderClass() throws Throwable {
	File f = new File("E:\\Java\\AmazonAutomation\\src\\test\\java\\com\\adactin\\helper\\configuration.properties");
	FileInputStream fis = new FileInputStream(f);
	p = new Properties();
	p.load(fis);
	
	}
	
	public String getBrowser() {
		
		String browserName = p.getProperty("browser");
		return browserName;
	}
	
	public String getUserName() {
		
		String userName = p.getProperty("username");
		return userName;

	}
	
	public String getPassword() {
		
		String passWord = p.getProperty("password");
		return passWord;

	}
	
	public String getOrderNumber() {
		String orderNumber = p.getProperty("orderNumber");
		return orderNumber;

	}

}
