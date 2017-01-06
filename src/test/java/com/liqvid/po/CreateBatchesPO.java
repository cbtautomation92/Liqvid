package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateBatchesPO {
	
	WebDriver driver = null;
	public CreateBatchesPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='ADD']")
	private WebElement eleAddBatchBtn;
	public WebElement getEleAddBatchBtn(){
		return eleAddBatchBtn;
	}
	
	@FindBy(xpath="//p[text()='REMOVE']")
	private WebElement eleRemoveBatchBtn;
	public WebElement getEleRemoveBatchBtn(){
		return eleRemoveBatchBtn;
	}
	
	@FindBy(xpath="(//div[@class='form-group pull-in clearfix'])[last()]")
	private WebElement eleClassOfCreateBatchLst;
	public WebElement getEleClassOfCreateBatchLst(){
		return eleClassOfCreateBatchLst;
	}
	
	@FindBy(xpath="//span[text()='Create Batch']")
	private WebElement eleCreateBatchLnk;
	public WebElement getEleCreateBatchLnk(){
		return eleCreateBatchLnk;
	}
	
	@FindBy(id="fld_class1")
	private WebElement eleClassLst;
	public WebElement getEleClassLst(){
		return eleClassLst;
	}
	
	@FindBy(id="fld_section1")
	private WebElement eleSectionFromLst;
	public WebElement getEleSectionFromLst(){
		return eleSectionFromLst;
	}
	
	@FindBy(id="fld_sectionT1")
	private WebElement eleSectionTillLst;
	public WebElement getEleSectionTillLst(){
		return eleSectionTillLst;
	}
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement eleCreateBtn;
	public WebElement getEleCreateBtn(){
		return eleCreateBtn;
	}

	@FindBy(xpath="//div[text()='Create Batch']")
	private WebElement eleCreateBatchTxt;
	public WebElement getEleCreateBatchTxt(){
		return eleCreateBatchTxt;
	}
}
