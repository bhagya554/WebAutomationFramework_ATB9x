package org.example.driver.selenoid;

import org.example.driver.DriverManager;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverManagerSelenoid {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    //when we want to start the browser
    public static void init() {
        String browser = PropertiesReader.readKey("browser").toLowerCase();
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    try {
                        ChromeOptions options = new ChromeOptions();
                        options.setCapability("browserVersion", "128.0");
                        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                            /* How to add test badge */
                            put("name", "VWO Login Testcases");
                            /* How to set session timeout */
                            put("sessionTimeout", "15m");
                            /* How to set timezone */
                            put("env", new ArrayList<String>() {{
                                add("TZ=UTC");
                            }});
                            /* How to add "trash" button */
                            put("labels", new HashMap<String, Object>() {{
                                put("automation", "true");
                            }});

                            /* How to enable video recording */
                            put("enableVideo", true);
                            put("enableVNC", true);
                        }});
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                        break;
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                case "firefox":
                    try{
                        FirefoxOptions options = new FirefoxOptions();
                        options.setCapability("browserVersion", "125.0");
                        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                            /* How to add test badge */
                            put("name", "Test badge...");

                            /* How to set session timeout */
                            put("sessionTimeout", "15m");

                            /* How to set timezone */
                            put("env", new ArrayList<String>() {{
                                add("TZ=UTC");
                            }});

                            /* How to add "trash" button */
                            put("labels", new HashMap<String, Object>() {{
                                put("manual", "true");
                            }});

                            /* How to enable video recording */
                            put("enableVideo", true);
                        }});
                       driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                    }
                    catch (MalformedURLException e){
                        throw new RuntimeException(e);
                    }
            }
        }

    }

    //when we want to close the browser
    public static void down() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
