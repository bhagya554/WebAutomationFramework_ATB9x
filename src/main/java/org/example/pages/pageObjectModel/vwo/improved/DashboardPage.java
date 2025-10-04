package org.example.pages.pageObjectModel.vwo.improved;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    By userNameOnDashboard= By.xpath("//span[@data-qa='lufexuloga']");
    public String loginUserName(){
       return getText(userNameOnDashboard);
    }
}
