package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BatchReportPO {


	WebDriver driver = null;
	public BatchReportPO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Batch Report')]")
	private WebElement eleBatchReportTxt;
	public WebElement getEleBatchReportTxt(){
		return eleBatchReportTxt;
	}
	

	@FindBy(id="fld_class")
	private WebElement eleSelectClassDrpDwn;
	public WebElement getEleSelectClassDrpDwn(){
		return eleSelectClassDrpDwn;
	}
	
	@FindBy(id="fld_section")
	private WebElement eleSelectSectionDrpDwn;
	public WebElement getEleSelectSectionDrpDwn(){
		return eleSelectSectionDrpDwn;
	}
	
	@FindBy(id="userType")
	private WebElement eleSelectUserTypeDrpDwn;
	public WebElement getEleSelectUserTypeDrpDwn(){
		return eleSelectUserTypeDrpDwn;
	}
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement eleSubmitBtn;
	public WebElement getEleSubmitBtn(){
		return eleSubmitBtn;
	}
	
	@FindBy(xpath="//div[@class='clearfix text-center m-t']")
	private WebElement eleThereAreNoUsersTxt;
	public WebElement getEleThereAreNoUsersTxt(){
		return eleThereAreNoUsersTxt;
	}

	@FindBy(xpath="//td[contains(text(),'Test Student Clair')]")
	private WebElement eleStudentNameTxt;
	public WebElement getEleStudentNameTxt(){
		return eleStudentNameTxt;
	}
	
	 
	@FindBy(xpath="//td[contains(text(),'TestStudent-3')]")
	private WebElement eleStudentLoginIDTxt;
	public WebElement getEleStudentLoginIDTxt(){
		return eleStudentLoginIDTxt;
	}
	
	
	@FindBy(xpath="//td[contains(text(),'student')]")
	private WebElement eleStudentPasswordTxt;
	public WebElement getEleStudentPasswordTxt(){
		return eleStudentPasswordTxt;
	}
	
	@FindBy(xpath="//td[contains(text(),'Test Jonny Depp')]")
	private WebElement eleTeacherNameTxt;
	public WebElement getEleTeacherNameTxt(){
		return eleTeacherNameTxt;
	}
	
	 
	@FindBy(xpath="//td[contains(text(),'TestJonny-1-35-13')]")
	private WebElement eleTeacherLoginIDTxt;
	public WebElement getEleTeacherLoginIDTxt(){
		return eleTeacherLoginIDTxt;
	}
	
	
	@FindBy(xpath="//td[contains(text(),'teacher')]")
	private WebElement eleTeacherPasswordTxt;
	public WebElement getEleTeacherPasswordTxt(){
		return eleTeacherPasswordTxt;
	}
}
