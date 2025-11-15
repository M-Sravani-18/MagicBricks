package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static Properties readProperty() {
        Properties prop = new Properties();
        String fileName = System.getProperty("user.dir") + ".\\src\\test\\resources\\com\\Properties\\profile.properties";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("File name or file path is not correct: " + fileName);
            e.printStackTrace();
        }
        return prop;
    }



	}


