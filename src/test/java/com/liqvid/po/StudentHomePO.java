package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liqvid.library.GenericLib;
public class StudentHomePO 
{
	WebDriver driver = null;
	public StudentHomePO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='/learning/themes/notebook/images/logo.png']")
	private WebElement eleEnglishEdgeLogo ;
	public WebElement getEnglishEdgeLogo()
	{
		return eleEnglishEdgeLogo;
	}
	
	@FindBy(xpath="//span[text()='Home']")
	private WebElement eleHomeLnk ;
	public WebElement getEleHomeLnk()
	{
		return eleHomeLnk;
	}
	
	@FindBy(xpath="//div[text()='Student Panel']")
	private WebElement eleStudentPaneltxt;
	public WebElement getStudentPaneltxt()
	{
		return eleStudentPaneltxt;
	}
	

	@FindBy(xpath="//label[@for='file-input']")
	private WebElement eleStudentProfilePhoto;
	public WebElement getStudentProfilePhoto()
	{
		return eleStudentProfilePhoto;
	}
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement eleBrowseBtn;
	public WebElement getBrowseBtn()
	{
		return eleBrowseBtn;
	}
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement eleSubmitBtn;
	public WebElement getSubmitBtn()
	{
		return eleSubmitBtn;
	}
	@FindBy(xpath="//span[text()='My Courses']")
	private WebElement eleMyCoursesLnk;
	public WebElement getMyCoursesLnk()
	{
		return eleMyCoursesLnk;
	}
	
	@FindBy(xpath="//div[@class='h3 userName']//strong")
	private WebElement eleUserNameTxt;
	public WebElement getUserNameTxt()
	{
		return eleUserNameTxt;
	}
	
	public boolean verifyNewStudentUserName() throws InterruptedException
	{
		String[] newLoginId= GenericLib.getCongigValue(GenericLib.sConfigFile, "STUDENTLOGINID").split("-");
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
