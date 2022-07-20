package com.ui.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationReader {
	public Properties properties = null;
	public static ConfigurationReader instanceofConfigReader = null;
	public static final String ERROR_MSG = "An error has occured while loading the properties file";
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationReader.class);
	
	private ConfigurationReader(String propFile) {
		try {
			File src = new File(propFile);
			FileInputStream fs = new FileInputStream(src);
			properties = new Properties();
			properties.load(fs);
			
			
		}catch (Exception ex){
			LOGGER.error(ERROR_MSG, ex);
		}
	}
	
	public static ConfigurationReader getInstance(String propFile) {
		if(instanceofConfigReader==null) {
			instanceofConfigReader = new ConfigurationReader(Paths.get(System.getProperty("user.dir"),"src","test", "java","Config", propFile).toString());
		}
		return instanceofConfigReader;
	}
	
	public static ConfigurationReader getInstance() {
		if(instanceofConfigReader==null) {
			getInstance("config.properties");
		}
		return instanceofConfigReader;
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}
}
