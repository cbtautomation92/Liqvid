package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPO
{
	WebDriver driver = null;
	public ForgotPasswordPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//small[contains(text(),'Forgot password?')]")
	private WebElement eleForgotPasswordLnk;
	public WebElement getEleForgotPasswordLnk()
	{
		return eleForgotPasswordLnk;
	}
	
	@FindBy(xpath="//p[text()='To retrieve Student/Teacher password please contact Admin.']")
	private WebElement eleContactAdminTxt;
	public WebElement getEleContactAdminTxt()
	{
		return eleContactAdminTxt;
	}
	
	@FindBy(xpath="//u[text()='Click Here']")
	private WebElement eleClickHereBtn;
	public WebElement getEleClickHereBtn()
	{
		return eleClickHereBtn;
	}
	
	@FindBy(xpath="//h1[contains(text(),'Welcome to Admin password Reset console.')]")
	private WebElement eleAdminPasswordResetTxt;
	public WebElement getEleAdminPasswordResetTxt()
	{
		return eleAdminPasswordResetTxt;
	}
	
	@FindBy(xpath="//input[@id='center_code']")
	private WebElement eleLoginIDTxtFld;
	public WebElement getEleLoginIDTxtFld()
	{
		return eleLoginIDTxtFld;
	}
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement eleSubmitBtn;
	public WebElement getEleSubmitBtn()
	{
		return eleSubmitBtn;
	}
}
