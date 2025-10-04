package org.example.pages.pageObjectModel.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }
    By dashboardText = By.xpath("//h6[normalize-space()='Dashboard']");

    public String getUserLoggedIn(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(dashboardText).isDisplayed();
       return driver.findElement(dashboardText).getText();
    }


}
