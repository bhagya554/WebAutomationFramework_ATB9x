package org.example.pages.pageFactory;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage_PF extends BasePage {
    WebDriver driver;

    public DashboardPage_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[@data-qa='lufexuloga']")
    WebElement userNameOnDashboard;
    public String loginUserName(){
        return getText(userNameOnDashboard);
    }
}
