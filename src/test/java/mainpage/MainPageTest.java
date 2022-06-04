package mainpage;

import utils.WebDriverFactory;
import org.itmo.masha.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utils.ConfProperties;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainPageTest {
    List<WebDriver> driverList;
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private MainPage mainPage;
    private JavascriptExecutor executor;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperties(Constants.CHROME));
        System.setProperty("webdriver.gecko.driver",  ConfProperties.getProperties(Constants.FIREFOX));
        driverList = new ArrayList<>();
        chromeDriver = WebDriverFactory.getWebDriver("chrome");
        firefoxDriver = WebDriverFactory.getWebDriver("firefox");
        driverList.add(chromeDriver);
        driverList.add(firefoxDriver);
        for(WebDriver driver : driverList) {
            driver.manage().window().maximize();
            driver.get("http://2gis.ru/");
        }

    }

    @AfterEach
    public void cleanUpEach(){
        for(WebDriver driver : driverList) {
            driver.quit();
        }
    }

    @Test
    public void jamsTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.jamsClick();
            Thread.sleep(2000);
            String tmp = driver.getCurrentUrl();
            Assertions.assertEquals(tmp, "https://2gis.ru/spb?traffic");
        }
    }

    @Test
    public void exchangeTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.exchangeClick();
            Thread.sleep(2000);
            String tmp = driver.getCurrentUrl();
            Assertions.assertEquals(tmp, "https://2gis.ru/spb/exchange?layer=exchange");
        }
    }

    @Test
    public void transportTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.transportClick();
            Thread.sleep(2000);
            String tmp = driver.getCurrentUrl();
            Assertions.assertEquals(tmp, "https://2gis.ru/spb?layer=eta");
        }
    }

    @Test
    public void subwayTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.subwayClick();
            Thread.sleep(2000);
            String tmp = driver.getCurrentUrl();
            Assertions.assertEquals(tmp, "https://2gis.ru/spb?layer=metro");
        }
    }

    @Test
    public void estateTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.estateClick();
            Thread.sleep(2000);
            String tmp = driver.getCurrentUrl();
            Assertions.assertEquals(tmp,"https://2gis.ru/spb/realty/sale");
        }
    }

    @Test
    public void loginTest() throws InterruptedException{
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.loginClick();
            Thread.sleep(2000);
            //fixme

        }
    }

    @Test
    public void eatTest() throws InterruptedException{
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.whereToEatClick();
            mainPage.inputEat(" пицца");
            Thread.sleep(2000);
            int count = Integer.parseInt(mainPage.getCount());
            Assertions.assertTrue(count > 0);
        }
    }


}
