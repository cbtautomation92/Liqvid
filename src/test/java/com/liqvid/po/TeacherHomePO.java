package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liqvid.library.GenericLib;

public class TeacherHomePO 
{

	WebDriver driver = null;
	public TeacherHomePO (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[text()='Teacher Panel']")
	private WebElement eleTeacherPanelTxt ;
	public WebElement getTeacherPanelTxt()
	{
		return eleTeacherPanelTxt;
	}
	@FindBy(xpath="//span[text()='Courses']")
	private WebElement eleCoursesLnk;
	public WebElement getCoursesLnk()
	{
		return eleCoursesLnk;
	}
	
	
	@FindBy(xpath="//div[@class='h3 userName']//strong")
	private WebElement eleUserNameTxt;
	public WebElement getUserNameTxt()
	{
		return eleUserNameTxt;
	}
	

	@FindBy(xpath="//li[@class='dropdown']")
	private WebElement eleDropdownLst;
	public WebElement getEleDropdownLst()
	{
		return eleDropdownLst;
	}
	
	@FindBy(xpath="//a[text()='Profile']")
	private WebElement eleProfileLnk;
	public WebElement getEleProfileLnk()
	{
		return eleProfileLnk;
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement eleLogoutLnk;
	public WebElement getEleLogoutLnk()
	{
		return eleLogoutLnk;
	}
	
	public boolean verifyNewTeacherUserName() throws InterruptedException
	{
		String[] newLoginId= GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERLOGINID").split("-");
	    System.out.println(newLoginId[0]);
	    String[] Username=getUserNameTxt().getText().split(" ");
	    if(Username[0].equals(newLoginId[0]))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;    
	    }
	}
}
