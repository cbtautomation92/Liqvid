package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchTeacherCoursePO 
{
	WebDriver driver = null;
	public  LaunchTeacherCoursePO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[text()='Learning']")
	private WebElement eleLearningTxt;
	public WebElement getLearningTxt()
	{
		return eleLearningTxt;
	}
	@FindBy(xpath="//option[text()='Class1 - Section A']")
	private WebElement eleClass1SectionABtn;
	public WebElement getClass1SectionABtn()
	{
		return eleClass1SectionABtn;
	}
	@FindBy(xpath="//option[text()='C1']")
	private WebElement eleCourse1Btn;
	public WebElement getCourse1Btn()
	{
		return eleCourse1Btn;
	}
	@FindBy(xpath="//div[@id='start']/input")
	private WebElement eleStartCourseBtn;
	public WebElement getStartCourseBtn()
	{
		return  eleStartCourseBtn;
	}

}
