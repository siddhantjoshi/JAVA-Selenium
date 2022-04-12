package com.hackathon.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertyFile {
	// initialize variables
	private Properties properties;
	private final String propertyFilePath = "src\\test\\resources\\config.properties";

	// default constructor
	public PropertyFile() {
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
	public String getSearchService() {
		String productName = properties.getProperty("searchProduct");
		if (productName != null)
			return productName;
		else
			throw new RuntimeException("Product name is not specified in properties file");
	}

	// get minimum filter price
	public String getLocation() {
		String location = properties.getProperty("location");
		if (location != null)
			return location;
		else
			throw new RuntimeException("Location is not specified in properties file");
	}

	// get minimum filter price
	public String getMinVotes() {
		String votes = properties.getProperty("minvote");
		if (votes != null)
			return votes;
		else
			throw new RuntimeException("Location is not specified in properties file");
	}

	// get minimum filter price
	public String getMinRatings() {
		String ratings = properties.getProperty("star");
		if (ratings != null)
			return ratings;
		else
			throw new RuntimeException("Location is not specified in properties file");
	}

}
