package org.example.tests.vwoTestcases;

import io.qameta.allure.Description;
import org.example.base.BaseTest;

import org.example.pages.pageObjectModel.vwo.improved.DashboardPage;
import org.example.pages.pageObjectModel.vwo.improved.LoginPage;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.driver.DriverManager.driver;

public class TestVWOLogin_05_improved_withPOMPropertiesReaderDMAndBaseTest extends BaseTest {


    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {
        logger.info("Started the execution of testcase | test_negative_vwo_login ");
        LoginPage loginPage = new LoginPage(driver);
        String actual_error_message=loginPage.loginToVWOWithInvalidCredentials(PropertiesReader.readKey("vwo_invalid_username"),PropertiesReader.readKey("vwo_invalid_password"));
        System.out.println(actual_error_message);
        assertThat(actual_error_message).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(actual_error_message, PropertiesReader.readKey("vwo_login_error_message"));
        logger.info("Test Done | test_negative_vwo_login");
    }

    @Description("Verify that with valid email, pass, dashboard is displayed")
    @Test
    public void test_positive_vwo_login() throws Exception {
        logger.info("Started the execution of testcase | test_positive_vwo_login ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOWithValidCredentials(PropertiesReader.readKey("vwo_username"),PropertiesReader.readKey("vwo_password"));

        DashboardPage dashboardPage = new DashboardPage(driver);
        String usernameLoggedIn=dashboardPage.loginUserName();

        assertThat(usernameLoggedIn).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_userName"));

        Thread.sleep(5000);
        logger.info("Test Done | test_positive_vwo_login");
    }

}
