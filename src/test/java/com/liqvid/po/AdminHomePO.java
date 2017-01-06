package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePO 
{

	WebDriver driver = null;
	public AdminHomePO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Welcome! Admin')]")
	private WebElement eleWelcomeAdminTxt;
	public WebElement getEleWelcomeAdminTxt(){
		return eleWelcomeAdminTxt;
	}
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement eleLogoutLink;
	public WebElement getEleLogoutLink(){
		return eleLogoutLink;
	}
	
	@FindBy(xpath="//span[contains(text(),'Batch Report')]")
	private WebElement eleBatchReport;
	public WebElement getEleBatchReport(){
		return eleBatchReport;
	}
}