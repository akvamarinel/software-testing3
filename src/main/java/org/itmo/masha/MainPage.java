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

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div/div[1]/header/div[3]/div/div[1]/div/div/a/span")
    private WebElement countEat;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/div/div[2]/div[1]/nav/ul/li[4]")
    private WebElement exchangeBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/div/div[2]/div[1]/nav/ul/li[3]")
    private WebElement transportBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/div/div[2]/div[1]/nav/ul/li[2]")
    private WebElement subwayBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[3]/div[1]/div/div[2]/div[1]/nav/ul/li[1]")
    private WebElement estateBtn;

    public void loginClick() {
        loginBtn.click();
    }

    public void jamsClick(){
        jamsBtn.click();
    }

    public void exchangeClick(){
        exchangeBtn.click();
    }

    public void transportClick(){
        transportBtn.click();
    }

    public void subwayClick(){
        subwayBtn.click();
    }
    public void estateClick(){
        estateBtn.click();
    }
    public void sideBarClick(){
        sideBar.click();
    }


    public String getCount(){
       return countEat.getText();
    }

}
