package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

//    public ConfigReader(String filePath) {
//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static {
        try {
            // Define the path to the configuration file
            String path = "src/test/resources/config/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}