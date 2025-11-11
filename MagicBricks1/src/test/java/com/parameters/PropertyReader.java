package com.parameters;
 
import java.io.FileInputStream;
import java.util.Properties;
 
public class PropertyReader {
	 private static Properties prop;
	
	    public static void loadProperties() {
	        try {
	            FileInputStream fis = new FileInputStream(
	                    "src/test/resources/com/Properties/profile.properties");
	            prop = new Properties();
	            prop.load(fis);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	    public static String get(String key) {
	        return prop.getProperty(key);
	    }
	}
 
 
 