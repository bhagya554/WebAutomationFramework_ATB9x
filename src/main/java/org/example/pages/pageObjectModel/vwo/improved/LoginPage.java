package org.example.pages.pageObjectModel.vwo.improved;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.driver.DriverManager.getDriver;

public class LoginPage extends BasePage {
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
       openVWOUrl();
       enterInput(username,uname);
       enterInput(password,pwd);
       clickElement(loginBtn);
       custom_wait(3000);
       return getText(error_message);
   }

    public void loginToVWOWithValidCredentials(String uname,String pwd){
        openVWOUrl();
        enterInput(username,uname);
        enterInput(password,pwd);
        clickElement(loginBtn);
        custom_wait(10000);
    }

}
