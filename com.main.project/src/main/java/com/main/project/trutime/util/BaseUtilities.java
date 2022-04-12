package com.main.project.trutime.util;

//initialize static varibles
public class BaseUtilities {
	//	Initialize variables
	protected static long PAGE_LOAD_TIMEOUT = 10;
	protected static long IMPLICIT_WAIT = 10;
	protected static String propertyFilePath = "src\\main\\resources\\object repository\\config.properties";
	
	//getter for varibales
	public static long getPAGE_LOAD_TIMEOUT() {
		return PAGE_LOAD_TIMEOUT;
	}

	public static long getIMPLICIT_WAIT() {
		return IMPLICIT_WAIT;
	}

	public static String getPropertyFilePath() {
		return propertyFilePath;
	}

}
