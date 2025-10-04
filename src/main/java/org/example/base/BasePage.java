package org.example.base;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.driver.DriverManager.getDriver;

public class BasePage {
    public BasePage(){

    }

    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("vwo_url"));
    }

    public void custom_wait(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement ele){
        ele.click();
    }

    public void enterInput(By by,String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement ele,String key){
        ele.sendKeys(key);
    }

    public String getText(By by){
       return getDriver().findElement(by).getText();
    }

    public String getText(WebElement ele){
        return ele.getText();
    }

    public WebElement presenceOfElement(By by){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement visibilityOfElement(By by){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getElement(By by){
        return getDriver().findElement(by);
    }

}
