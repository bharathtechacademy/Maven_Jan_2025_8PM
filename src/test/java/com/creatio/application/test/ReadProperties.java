package com.creatio.application.test;

import java.util.Properties;

import com.creatio.framework.utilities.ReadProp;

public class ReadProperties {

	public static void main(String[] args) {
		
		Properties akProp = ReadProp.readData("Akshay.properties");
		Properties prop = ReadProp.readData("Config.properties");
		
		System.out.println(akProp.getProperty("name"));		
		System.out.println(prop.getProperty("ApplicationUrl"));

	}

}
