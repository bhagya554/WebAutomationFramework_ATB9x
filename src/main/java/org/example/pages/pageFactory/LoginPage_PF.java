package org.example.pages.pageFactory;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends BasePage {
    WebDriver driver;

    public LoginPage_PF(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id="login-username")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(id="js-login-btn")
    WebElement loginBtn;
    @FindBy(className="notification-box-description")
    WebElement error_message;


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
