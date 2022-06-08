package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    private static FileInputStream fileInputStream;
    private static Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream("conf.properties");
            //fileInputStream = new FileInputStream(System.getenv("DRIVER_PATH"));

            try {
                properties = new Properties();
                properties.load(fileInputStream);
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}
