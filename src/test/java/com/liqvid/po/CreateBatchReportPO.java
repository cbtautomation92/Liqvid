package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateBatchReportPO {

	
	WebDriver driver = null;
	public CreateBatchReportPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//td[contains(text(),'Batch Already Exist')]")
	private WebElement eleBatchAlreadyExistTxt;
	public WebElement getEleBatchAlreadyExistTxt(){
		return eleBatchAlreadyExistTxt;
	}
	
	@FindBy(xpath="//td[contains(text(),'Batch Created')]")
	private WebElement eleBatchCreatedTxt;
	public WebElement getEleBatchCreatedTxt(){
		return eleBatchCreatedTxt;
	}
}
