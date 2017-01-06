package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentCourseSessionPO 
{

	WebDriver driver = null;
	public StudentCourseSessionPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//iframe[@id='iframes']")
	private WebElement eleiframe;
	public WebElement getiframe()
	{
		return eleiframe;
	}

	@FindBy(xpath="//a[text()='Session1']")
	private WebElement eleSession1lnk;
	public WebElement getSession1lnk()
	{
		return eleSession1lnk;
	}

	@FindBy(xpath="//span[contains(text(),'The goat – eater ')]")
	private WebElement eleGoatEaterTitle;
	public WebElement getGoatEaterTitle()
	{
		return eleGoatEaterTitle;
	}
	
	@FindBy(id="imgExit")
	private WebElement eleExitBtn;
	public WebElement getEleExitBtn()
	{
		return eleExitBtn;
	}
	
	
	}
