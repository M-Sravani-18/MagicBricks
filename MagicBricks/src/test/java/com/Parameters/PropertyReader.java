//package com.Parameters;
// 
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
// 
//public class PropertyReader {
//	public static Properties readProperty() {
//		Properties prop = null;
//		String fileName = ".\\src\\test\\resources\\PropertieFlies\\Profile.properties";
//		try
//		{
//			FileInputStream fis  = new FileInputStream(fileName);
//			prop = new Properties();
//			prop.load(fis);				
//		}
//		catch(FileNotFoundException e)
//		{
//			System.out.println("File name or file path is not correct");
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		
//		return prop;
//		
//	}
// 
//	
//}
 
//package com.Parameters;
// 
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
// 
//public class PropertyReader {
//    private static Properties prop;
// 
//    static {
//        String fileName = ".\\src\\test\\resources\\PropertieFlies\\Profile.properties";
//        try {
//            FileInputStream fis = new FileInputStream(fileName);
//            prop = new Properties();
//            prop.load(fis);
//        } catch (IOException e) {
//            System.out.println(" Failed to load properties file: " + e.getMessage());
//        }
//    }
// 
//    public static String getProperty(String key) {
//        return prop.getProperty(key);
//    }
//
//	public static Properties readProperty() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}

package com.Parameters;
 
import java.io.FileInputStream;
 
import java.io.FileNotFoundException;
 
import java.io.IOException;
 
import java.util.Properties;
 
public class PropertyReader {
 
    private static Properties prop = new Properties();
 
    public static Properties readProperty() {
 
        String fileName = ".\\src\\test\\resources\\PropertieFlies\\Profile.properties";
 
        try {
 
            FileInputStream fis = new FileInputStream(fileName);
 
            prop.load(fis);
 
        } catch (FileNotFoundException e) {
 
            System.out.println("File name or file path is not correct");
 
        } catch (IOException e) {
 
            e.printStackTrace();
 
        }
 
        return prop;
 
    }
 
    // Method to get property value by key
 
//    public static String get(String key) {
// 
//        return prop.getProperty(key);
// 
//    }
 
}
 