package com.adactin.helper;

public class FileReaderManager {
	
	private FileReaderManager() {
		
	}
	
	public static FileReaderManager getInstanceFRM() {
		
		FileReaderManager FRM = new FileReaderManager();
		return FRM;

	}
	
	public configurationReaderClass getInstanceCR() throws Throwable {
		
		configurationReaderClass CR = new configurationReaderClass();
		return CR;
		
	}
	
	

}
