package mainpage;

import factory.WebDriverFactory;
import org.itmo.masha.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import prop.ConfProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    List<WebDriver> driverList;
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperties("chromedriver"));
        System.setProperty("webdriver.gecko.driver",  ConfProperties.getProperties("geckodriver"));
//        System.setProperty("webdriver.chrome.driver", "/home/mashusik/course/twogis-test/drivers/chromedriver");
//        System.setProperty("webdriver.gecko.driver", "/home/mashusik/course/twogis-test/drivers/geckodriver");

        driverList = new ArrayList<>();
        chromeDriver = WebDriverFactory.getWebDriver("chrome");
        firefoxDriver = WebDriverFactory.getWebDriver("firefox");
        driverList.add(chromeDriver);
        driverList.add(firefoxDriver);
        for(WebDriver driver : driverList) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://2gis.ru/");
        }

    }

//    @AfterEach
    public void cleanUpEach(){
        for(WebDriver driver : driverList) {
            driver.quit();
        }
    }

    @Test
    public void jamsTest(){
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.jamsClick();
        }
    }

    @Test
    public void loginTest(){
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.loginClick();
        }
    }

    @Test
    public void eatTest(){
        for (WebDriver driver : driverList) {
            mainPage = new MainPage(driver);
            mainPage.whereToEatClick();
            mainPage.inputEat(" пицца");
            int count = Integer.parseInt(mainPage.getCount());
            Assertions.assertTrue(count > 0);
        }
    }


}
