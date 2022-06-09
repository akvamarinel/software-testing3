package org.itmo.masha;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new ChromeDriver();
        //WebDriver driver1 = new FirefoxDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("http://2gis.ru/");
       // driver1.get("http://2gis.ru/");
        MainPage mainPage = new MainPage(driver);
        //mainPage.jamsClick();
        mainPage.exchangeClick();
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10000,
              //  TimeUnit.MILLISECONDS);

        System.out.println(((JavascriptExecutor) driver).executeScript("return document.location.href"));
        //System.out.println(driver.getCurrentUrl());
        System.out.println(System.getenv("DRIVER_PATH"));
    }
}
