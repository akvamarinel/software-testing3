package org.itmo.masha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/mashusik/course/twogis-test/drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/mashusik/course/twogis-test/drivers/geckodriver");
        WebDriver driver = new ChromeDriver();
        WebDriver driver1 = new FirefoxDriver();

        driver.get("http://2gis.ru/");
        driver1.get("http://2gis.ru/");
    }
}
