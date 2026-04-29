package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	    
			public LoginPage(WebDriver driver) {
				super(driver);
			}
			
			@FindBy(name="username")
			public WebElement userName;
			
			@FindBy(name="password")
			public WebElement passWord;
			
			
			@FindBy(xpath="//h5[normalize-space()='Login']")
			public WebElement login_text;
			
			@FindBy(xpath="//button[@type='submit']")
			public WebElement login;
			
			@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
			public WebElement message;
			
			public void login(String strusername,String strpassword) {
				userName.sendKeys(strusername);
				passWord.sendKeys(strpassword);
				login.click();
				log.info("Login action performed");
				
				
			}
	
			public String getLoginTitle() {
				return login_text.getText();	
			}	
			public String getInvalidMessage() {
				return message.getText();
			}
}