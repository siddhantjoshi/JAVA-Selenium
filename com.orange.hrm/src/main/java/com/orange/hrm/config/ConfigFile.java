package com.orange.hrm.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFile {

	// initialize variables
	private Properties properties;
	private final String propertyFilePath = "src\\main\\resources\\config.properties";

	// default constructor
	public ConfigFile() {
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(bufferedReader);
				bufferedReader.close();
			} catch (Exception e) {
				System.out.println("ERROR:\n" + e);
			}
		} catch (Exception e) {
			System.out.println("ERROR:\n" + e);
			throw new RuntimeException("Property file is not present at location: " + propertyFilePath);
		}
	}

	// get base URL
	public String getBaseURL() {
		String baseURL = properties.getProperty("baseURL");
		if (baseURL != null)
			return baseURL;
		else
			throw new RuntimeException("Base URL is not specified in properties file");
	}

	// get product name
	public String getbrowser() {
		String productName = properties.getProperty("browser");
		if (productName != null)
			return productName;
		else
			throw new RuntimeException("Browser name is not specified in properties file");
	}

	// get user name
	public String getUserName() {
		String productName = properties.getProperty("userName");
		if (productName != null)
			return productName;
		else
			throw new RuntimeException("Browser name is not specified in properties file");
	}

	// get user password
	public String getUserPassword() {
		String productName = properties.getProperty("userPassword");
		if (productName != null)
			return productName;
		else
			throw new RuntimeException("Browser name is not specified in properties file");
	}
}
