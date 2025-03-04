package com.creatio.application.test;

import java.util.Properties;

import com.creatio.framework.utilities.PropUtil;

public class ReadProperties {

	public static void main(String[] args) {
		
		Properties akProp = PropUtil.readData("Akshay.properties");
		Properties prop = PropUtil.readData("Config.properties");
		
		System.out.println(akProp.getProperty("name"));		
		System.out.println(prop.getProperty("ApplicationUrl"));

	}

}
