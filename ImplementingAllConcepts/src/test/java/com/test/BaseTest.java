package com.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pages.DashboardPage;
import com.pages.LoginPage;

public class BaseTest {

    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    

    protected static final Logger log = LogManager.getLogger(BaseTest.class);

    
    protected LoginPage objLogin;
    protected DashboardPage objDashboardPage;

   
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

   
    @BeforeMethod
    public void setup() {
        log.info("Setting up WebDriver for thread: " + Thread.currentThread());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        threadDriver.set(new ChromeDriver(options));
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        threadDriver.set(driver);
        log.info("Browser launched and navigated to OrangeHRM.");
    }

  
    @AfterMethod
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            log.info("Closing browser for thread: " + Thread.currentThread());
            driver.quit();
            threadDriver.remove();
        }
    }
}