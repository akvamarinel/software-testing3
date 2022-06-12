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

 //   @AfterEach
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
            sectionsPage.cancelCookiesClick();
            sectionsPage.clickPageCounter();
            Thread.sleep(1000);
            WebElement example = sectionsPage.getContainer().findElement(By.xpath("./div/div[2]/div/div[3]/div"));
            example.click();
            sectionsPage.clickInfo();
            Thread.sleep(1000);
            List<WebElement> elements = sectionsPage.getPlaceExample().findElements(By.xpath("./div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/span/span"));
            int count = 0;
            for (WebElement element : elements) {
                System.out.println(element.getText());
                if (element.getText().toLowerCase().contains("пицца")) {
                    count++;
                }
            }
            Assertions.assertTrue(count > 0);
        }
    }

    //todo: fix pharmacy and beauty via findElementS!! fix pageobjects

    @Test
    public void pharmacyTest() throws InterruptedException{
        for (WebDriver driver : driverList){
            sectionsPage = new SectionsPage(driver);
            sectionsPage.pharmacyBtnClick();
            Thread.sleep(1000);
            WebElement pharmacyExample = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div"));

            Thread.sleep(1000);
            pharmacyExample.click();
            Thread.sleep(500);
            sectionsPage.clickInfo();
            Thread.sleep(1000);
            WebElement exampleInfo1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/div[3]/div[2]/div/div/span/span[1]/a"));
            WebElement exampleInfo2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/div[3]/div[2]/div/div/span/span[2]/a"));

            List <WebElement> elementsList = new ArrayList<>();
            elementsList.add(exampleInfo1);
            elementsList.add(exampleInfo2);

            int count = 0;
            for(WebElement element : elementsList){
                if(element.getText().toLowerCase().contains("аптек") || element.getText().toLowerCase().contains("лекарств")){
                    count++;
                }
            }
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
            WebElement exampleBeauty = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div"));
            Thread.sleep(1000);
            exampleBeauty.click();
            Thread.sleep(1000);
            sectionsPage.clickInfo();
            Thread.sleep(1000);
            WebElement exampleInfo1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/div[3]/div[2]/div/div/span/a"));
            System.out.println(exampleInfo1.getText());
            Assertions.assertTrue((exampleInfo1.getText().toLowerCase().contains("ногтев") || exampleInfo1.getText().toLowerCase().contains("манкюр")));
        }
    }
}
