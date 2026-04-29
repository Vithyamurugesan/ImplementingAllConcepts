package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class BasePage {
	public static Logger log=LogManager.getLogger(BasePage.class);
	
	public WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		log.info("Initiate the elements");
	
	}
}




