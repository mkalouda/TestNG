package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static Properties readProperties(String filpath) {
        try {
            FileInputStream fis = new FileInputStream(filpath);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return prop;
    }

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
}
