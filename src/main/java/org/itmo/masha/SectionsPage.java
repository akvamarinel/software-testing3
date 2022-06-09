package org.itmo.masha;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SectionsPage {
    private WebDriver driver;
    private JavascriptExecutor executor;
    public SectionsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div")
    private WebElement container;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/footer/div[2]")
    private WebElement cookieCancelBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div/div/div[3]/div[1]/a[1]")
    private WebElement pageCounter;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/a/div/img")
    private WebElement whereToEatBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div[2]/div/div[2]/a/div/img")
    private WebElement pharmacyBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div[2]/div/div[3]/a/div/img")
    private WebElement beautyBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[2]/form/div/input")
    private WebElement eatField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div[1]/div/div[1]/div/div/div/div/div[2]/form/div/input")
    private WebElement beautyField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div/a")
    private WebElement infoElem;



    public void scrollContainer(){
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight);", container);
    }
    public void cancelCookiesClick(){
        cookieCancelBtn.click();
    }

    public void clickPageCounter(){
        pageCounter.click();
    }
    public void whereToEatClick(){
        whereToEatBtn.click();
    }

    public void inputEat(String smth){
        eatField.sendKeys(smth);
        eatField.sendKeys(Keys.ENTER);
    }

    public void inputBeauty(String smth){
        beautyField.sendKeys(smth);
        beautyField.sendKeys(Keys.ENTER);
    }
    public void pharmacyBtnClick(){
        pharmacyBtn.click();
    }

    public void beautyBtnClick(){
        beautyBtn.click();
    }

    public void clickInfo(){
        infoElem.click();
    }

}

