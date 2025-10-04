package org.example.tests.orangehrmTestcases;

import io.qameta.allure.Description;
import org.example.pages.pageObjectModel.orangehrm.DashboardPage;
import org.example.pages.pageObjectModel.orangehrm.LoginHRPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangeHRMLogin_POM {
    WebDriver driver;
    @Description("Driver is loaded and navigate to orange hrm")
    @BeforeMethod
    public void launchWebsite(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");


        driver = new EdgeDriver(edgeOptions);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Description("Verify that with invalid email, pass, error message is shown on the orangehrm")
    @Test
    public void test_negative_vwo_login() throws Exception {
        LoginHRPage loginPage = new LoginHRPage(driver);
        String actual_error_message=loginPage.doLoginWithInvalidCred("admin","admin");
        assertThat(actual_error_message).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(actual_error_message, "Invalid credentials");

        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }

    @Description("Verify that with valid email, pass, dashboard is displayed")
    @Test
    public void test_positive_vwo_login() throws Exception {
        LoginHRPage loginPage = new LoginHRPage(driver);
        loginPage.doLoginWithValidCred("Admin","admin123");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String usernameLoggedIn=dashboardPage.getUserLoggedIn();
        System.out.println(usernameLoggedIn);
        assertThat(usernameLoggedIn).isNotEmpty().isNotBlank().isNotNull();

        Assert.assertTrue(usernameLoggedIn.equals("Dashboard"));

        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null
    }
}
