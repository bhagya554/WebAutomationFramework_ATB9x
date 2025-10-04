package org.example.tests.vwoTestcases;

import io.qameta.allure.Description;
import org.example.pages.pageObjectModel.vwo.simple.DashboardPage;
import org.example.pages.pageObjectModel.vwo.simple.LoginPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_03_withPOMPropertiesReader {
    WebDriver driver;
    @Description("Driver is loaded and navigate to app.vwo.com")
    @BeforeMethod
    public void launchWebsite(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
        driver.get(PropertiesReader.readKey("vwo_url"));
    }

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        String actual_error_message=loginPage.loginToVWOWithInvalidCredentials(PropertiesReader.readKey("vwo_invalid_username"),PropertiesReader.readKey("vwo_invalid_password"));
        assertThat(actual_error_message).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(actual_error_message, PropertiesReader.readKey("vwo_login_error_message"));

        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }

    @Description("Verify that with valid email, pass, dashboard is displayed")
    @Test
    public void test_positive_vwo_login() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOWithValidCredentials(PropertiesReader.readKey("vwo_username"),PropertiesReader.readKey("vwo_password"));

        DashboardPage dashboardPage = new DashboardPage(driver);
        String usernameLoggedIn=dashboardPage.loginUserName();

        assertThat(usernameLoggedIn).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_userName"));

        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }

}
