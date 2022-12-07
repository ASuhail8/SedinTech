package postman.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static String getProperty(String propertyName) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/abdullasuhail/eclipse-workspace2/Rest/src/test/resources/config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(propertyName);
    }
}
