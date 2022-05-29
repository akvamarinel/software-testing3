package org.itmo.masha;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/div/div[2]/div[3]/div/div/div/div/div")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/div/div[2]/div[2]/a/button")
    private WebElement jamsBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/button/div")
    private WebElement sideBar;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/a/div/img")
    private WebElement whereToEatBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[2]/form/div/input")
    private WebElement eatField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[1]/header/div[3]/div/div[1]/div/div/a/span")
    private WebElement countEat;

    public void loginClick() {
        loginBtn.click();
    }

    public void jamsClick(){
        jamsBtn.click();
    }

    public void sideBarClick(){
        sideBar.click();
    }

    public void whereToEatClick(){
        whereToEatBtn.click();
    }

    public void inputEat(String smth){
        eatField.sendKeys(smth);
        eatField.sendKeys(Keys.ENTER);
    }

    public String getCount(){
       return countEat.getText();
    }

}
