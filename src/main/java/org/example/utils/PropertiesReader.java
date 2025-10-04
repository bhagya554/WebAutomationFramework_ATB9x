package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String key) {
        FileInputStream fis;
        Properties prop;
        try {
            fis = new FileInputStream("./src/main/resources/data/data.properties");
            prop = new Properties();
            prop.load(fis);
            return prop.getProperty(key);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
