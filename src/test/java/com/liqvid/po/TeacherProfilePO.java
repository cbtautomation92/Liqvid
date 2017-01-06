package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherProfilePO 
{

	WebDriver driver = null;
	public TeacherProfilePO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Profile']")
	private WebElement eleProfileTxt;
	public WebElement getEleProfileTxt()
	{
		return  eleProfileTxt;
	}
	
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement eleFirstNameTxtFld;
	public WebElement getEleFirstNameTxtFld()
	{
		return  eleFirstNameTxtFld;
	}
	
	@FindBy(xpath="//input[@name='email_id']")
	private WebElement eleEmailIDTxtFld;
	public WebElement getEleEmailIDTxtFld()
	{
		return  eleEmailIDTxtFld;
	}
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement elePhoneTxtFld;
	public WebElement getElePhoneTxtFld()
	{
		return  elePhoneTxtFld;
	}
	@FindBy(xpath="//a[@id='chPassword']")
	private WebElement elechPasswordLnk;
	public WebElement getElechPasswordLnk()
	{
		return  elechPasswordLnk;
	}
	
	@FindBy(xpath="//input[@name='old_password']")
	private WebElement eleOldPasswardTxtFld;
	public WebElement getEleOldPasswardTxtFld()
	{
		return  eleOldPasswardTxtFld;
	}
	@FindBy(xpath="//input[@name='password']")
	private WebElement eleNewPasswardTxtFld;
	public WebElement getEleNewPasswardTxtFld()
	{
		return eleNewPasswardTxtFld;
	}
	
	@FindBy(xpath="//input[@id='cpwd']")
	private WebElement eleConfirmNewPasswordTxtFld;
	public WebElement getEleConfirmNewPasswordTxtFld()
	{
		return  eleConfirmNewPasswordTxtFld;
	}
	
	@FindBy(xpath="//div[@class='checkbox']/button")
	private WebElement eleUpdateBtn;
	public WebElement getEleUpdateBtn()
	{
		return  eleUpdateBtn;
	}
	
	@FindBy(xpath="//input[@name='last_name']")
	private WebElement eleLastNameTxtFld;
	public WebElement getEleLastNameTxtFld()
	{
		return  eleLastNameTxtFld;
	}
	
	@FindBy(xpath="//p[@id='errMsg']/font[contains(text(),'Updated Successfully')]")
	private WebElement eleUpdatedSuccessTxt;
	public WebElement getEleUpdatedSuccessTxt()
	{
		return  eleUpdatedSuccessTxt;
	}
	
	
	
}
