package org.example.pages.pageObjectModel.vwo.simple;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.driver.DriverManager.getDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

   private By username = By.id("login-username");
   private By password = By.name("password");
   private By loginBtn = By.id("js-login-btn");
   private By error_message= By.className("notification-box-description");

//private By SignInUsingSSo=By.xpath("//button[normalize-space()='Sign in using SSO']");

   public String loginToVWOWithInvalidCredentials(String uname,String pwd){
       driver.get(PropertiesReader.readKey("vwo_url"));
       driver.findElement(username).sendKeys(uname);
       driver.findElement(password).sendKeys(pwd);
       driver.findElement(loginBtn).click();
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       String errorMessage=driver.findElement(error_message).getText();
       return  errorMessage;
   }

    public void loginToVWOWithValidCredentials(String uname,String pwd){
        driver.get(PropertiesReader.readKey("vwo_url"));
        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();

    }

}
