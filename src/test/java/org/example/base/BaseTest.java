package org.example.base;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.DriverManager;
import org.example.utils.ExcelReader;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public ExcelReader excel = new ExcelReader("./src/main/resources/data/testData.xlsx");
    public static final Logger logger = LogManager.getLogger(BaseTest.class);



    @Description("Driver is loaded and navigate to app.vwo.com")
    @BeforeMethod
    public void setUp(ITestResult result){
        DriverManager.init();
        logger.info("Started the execution of testcase: " +result.getMethod().getMethodName());
        logger.info("Driver Launched successfully..");

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        DriverManager.down();
        logger.info("Execution of the test completed : " + result.getMethod().getMethodName());
    }
}
