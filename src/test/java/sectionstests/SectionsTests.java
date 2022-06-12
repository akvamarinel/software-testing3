package sectionstests;

import org.itmo.masha.SectionsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfProperties;
import utils.Constants;
import utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

public class SectionsTests {
    List<WebDriver> driverList;
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private SectionsPage sectionsPage;
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

    @AfterEach
    public void cleanUpEach() {
        for (WebDriver driver : driverList) {
            driver.quit();
        }
    }

    @Test
    public void eatTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            sectionsPage = new SectionsPage(driver);
            sectionsPage.whereToEatClick();
            sectionsPage.inputEat(" пицца");
            Thread.sleep(2000);
            sectionsPage.scrollContainer();
            Thread.sleep(2000);
            sectionsPage.cancelCookiesClick();
            Thread.sleep(1000);
            sectionsPage.clickPageCounter();
            Thread.sleep(1000);
            WebElement examplePizza = sectionsPage.getContainer().findElement(By.xpath("./div/div[2]/div/div[2]/div"));
            examplePizza.click();
            sectionsPage.clickInfo();
            Thread.sleep(1000);

            List<WebElement> elements = sectionsPage.getPlaceExample().findElements(By.xpath("./div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/span"));
            int count = 0;
            for (WebElement element : elements) {
                System.out.println(element.getText());
                if (element.getText().toLowerCase().contains("пицца")) {
                    count++;
                }
            }
            Thread.sleep(1000);
            Assertions.assertTrue(count > 0);
        }
    }


    @Test
    public void pharmacyTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            sectionsPage = new SectionsPage(driver);
            sectionsPage.pharmacyBtnClick();
            Thread.sleep(1000);
            WebElement examplePharmacy = sectionsPage.getContainer().findElement(By.xpath("./div/div[2]/div/div[3]/div"));
            examplePharmacy.click();
            Thread.sleep(2000);
            sectionsPage.clickInfo();
            Thread.sleep(1000);

            List<WebElement> elements = sectionsPage.getPlaceExample().findElements(By.xpath("./div/div/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div"));
            int count = 0;
            for(WebElement element : elements){
                System.out.println(element.getText());
                if(element.getText().toLowerCase().contains("аптек") || element.getText().toLowerCase().contains("лекарств")){
                    count++;
                }
            }
            Thread.sleep(1000);
            Assertions.assertTrue(count > 0);
        }
    }

    @Test
    public void beautyTest() throws InterruptedException {
        for (WebDriver driver : driverList) {
            sectionsPage = new SectionsPage(driver);
            sectionsPage.beautyBtnClick();
            sectionsPage.inputBeauty(" ноготочки");
            Thread.sleep(2000);
            WebElement exampleBeauty = sectionsPage.getContainer().findElement(By.xpath("./div/div[2]/div/div[1]/div"));
            Thread.sleep(1000);
            exampleBeauty.click();
            Thread.sleep(1000);
            sectionsPage.clickInfo();
            Thread.sleep(1000);
            //*[@id="root"]/div/div/div[1]/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div/span
            List<WebElement> elements = sectionsPage.getPlaceExample().findElements(By.xpath("./div/div/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div/span"));
            int count = 0;
            for(WebElement element : elements){
                System.out.println(element.getText());
                if(element.getText().toLowerCase().contains("маникюр") || element.getText().toLowerCase().contains("ногт")){
                    count++;
                }
            }
            Thread.sleep(1000);
            Assertions.assertTrue(count > 0);
        }
    }
}
