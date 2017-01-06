package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPO 
{
	
	WebDriver driver = null;
	public RegistrationPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@class='radio-custom  radio-custom-2 rounded label-color']/i")
	private WebElement eleIHaveInternetConnectivityRdBtn;
	public WebElement getEleIHaveInternetConnectivityRdBtn(){
		return eleIHaveInternetConnectivityRdBtn;
	}
	
	@FindBy(xpath="//button[text()='NEXT']")
	private WebElement eleInternetCheckNxtBtn;
	public WebElement getEleInternetCheckNxtBtn(){
		return eleInternetCheckNxtBtn;
	}
	
	@FindBy(xpath="//h1[contains(text(),'Welcome')]")
	private WebElement eleWelcomeToEnglishEdgeHdrTxt;
	public WebElement getEleWelcomeToEnglishEdgeHdrTxt(){
		return eleWelcomeToEnglishEdgeHdrTxt;
	}
	
	
	@FindBy(xpath="//a[text()='NEXT']")
	private WebElement englishEdgeActvationNxtBtn;
	public WebElement getEleEnglishEdgeActvationNxtBtn(){
		return englishEdgeActvationNxtBtn;
	}
	
	@FindBy(xpath="//h1[text()='Registration Code']")
	private WebElement eleRegistrationCodeHdrTxt;
	public WebElement getEleRegistrationCodeHdrTxt(){
		return eleRegistrationCodeHdrTxt;
	}
	
	@FindBy(xpath="//input[@id='client_code']")
	private WebElement eleRegistrationCodeTxtFld;
	public WebElement getEleRegistrationCodeTxtFld(){
		return eleRegistrationCodeTxtFld;
	}
	
	@FindBy(xpath="//button[text()='SUBMIT']")
	private WebElement eleRegistrationCodeSbmtBtn;
	public WebElement getEleRegistrationCodeSbmtBtn(){
		return eleRegistrationCodeSbmtBtn;
	}
	
	
	@FindBy(xpath="//h1[text()='License Key']")
	private WebElement eleLicenceTxt;
	public WebElement getEleLicenceTxt(){
		return eleLicenceTxt;
	}
	
	@FindBy(xpath="//div[text()='Incorrect Registration Code or check internet connection. Please try again.']")
	private WebElement eleErrorMsgForRegistrationCodeTxt;
	public WebElement getEleErrorMsgForRegistrationCodeTxt(){
		return eleErrorMsgForRegistrationCodeTxt;
	}
	
	@FindBy(xpath="//input[@id='license']")
	private WebElement eleLicenceKeyTxtFld;
	public WebElement getEleLicenceKeyTxtFld(){
		return eleLicenceKeyTxtFld;
	}
	
	@FindBy(xpath="//button[text()='SUBMIT']")
	private WebElement eleLicenceKeySbmtBtn;
	public WebElement getEleLicenceKeySbmtBtn(){
		return eleLicenceKeySbmtBtn;
	}
	
	
	@FindBy(xpath="//div[text()='Incorrect license Key. Please try again.']")
	private WebElement eleErrorMsgForLicenceKeyTxt;
	public WebElement getEleErrorMsgForLicenceKeyTxt(){
		return eleErrorMsgForLicenceKeyTxt;
	}
	
}
