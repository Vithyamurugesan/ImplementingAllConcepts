package com.test;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class TestListeners implements ITestListener {

	private static final Logger log = LogManager.getLogger(TestListeners.class);

	public void onTestStart(ITestResult result) {
		log.info(result.getName() + " test started");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test PASSED: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		log.error("Test FAILED: " + result.getName());

		WebDriver driver = BaseTest.getDriver();
		if (driver == null) return;
		
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			new File(System.getProperty("user.dir") + "/screenshots/").mkdirs();

			String path = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";

			FileUtils.copyFile(source, new File(path));
			log.info("Screenshot saved: " + path);

		} catch (IOException e) {
			log.error("Screenshot failed: " + e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {
		log.warn("Test SKIPPED: " + result.getName());
	}
}
