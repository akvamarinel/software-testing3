package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

   public static WebDriver getWebDriver(String browserName){
        switch (browserName) {
            case "firefox":
                return new FirefoxDriver();

            case "chrome":
                return new ChromeDriver();

            default:
                throw new IllegalArgumentException("please, put correct browser name");
        }
    }
}
