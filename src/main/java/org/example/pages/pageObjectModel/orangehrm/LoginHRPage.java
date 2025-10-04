package org.example.pages.pageObjectModel.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRPage {
    WebDriver driver;

    public LoginHRPage(WebDriver driver){
        this.driver=driver;
    }

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[normalize-space()='Login']");
    By error_message = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    public void doLoginWithValidCred(String uname,String pwd){
        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
    }

    public String doLoginWithInvalidCred(String uname,String pwd){
        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String error_msg = driver.findElement(error_message).getText();
        return error_msg;
    }
}
