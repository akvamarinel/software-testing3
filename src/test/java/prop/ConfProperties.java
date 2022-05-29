package prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    private static FileInputStream fileInputStream;
    private static Properties properties;
    static {
        try {
            fileInputStream = new FileInputStream("/home/mashusik/course/twogis-test/src/test/resources/conf.properties");
            try {
                properties = new Properties();
                properties.load(fileInputStream);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static String getProperties(String key){
        return properties.getProperty(key);
    }
}
