package org.example.pages.pageObjectModel.vwo.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    By userName= By.xpath("//span[@data-qa='lufexuloga']");
    public String loginUserName(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(userName).getText();
    }
}
