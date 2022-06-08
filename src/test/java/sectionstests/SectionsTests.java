package sectionstests;

import org.itmo.masha.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.ConfProperties;
import utils.Constants;
import utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

public class SectionsTests {
    List<WebDriver> driverList;
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private MainPage mainPage;
    private JavascriptExecutor executor;

    @BeforeEach
    public void setUp() {
        System.setProperty(Constants.WEBDRIVER_CHROME, ConfProperties.getProperties(Constants.CHROME));
        System.setProperty(Constants.WEBDRIVER_FIREFOX, ConfProperties.getProperties(Constants.FIREFOX));
        driverList = new ArrayList<>();
        chromeDriver = WebDriverFactory.getWebDriver("chrome");
        firefoxDriver = WebDriverFactory.getWebDriver("firefox");
        driverList.add(chromeDriver);
        driverList.add(firefoxDriver);
        for (WebDriver driver : driverList) {
            driver.manage().window().maximize();
            driver.get("http://2gis.ru/");
        }

    }

}
