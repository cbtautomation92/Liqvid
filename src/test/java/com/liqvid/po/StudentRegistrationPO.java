package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.liqvid.library.GenericLib;

public class StudentRegistrationPO {

	WebDriver driver = null;
	public StudentRegistrationPO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//li[@id='studentLi']")
	private WebElement eleStudentLnk;
	public WebElement getEleStudentLnk(){
		return eleStudentLnk;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_first_name']")
	private WebElement eleFirstNameTxtFld;
	public WebElement getEleFirstNameTxtFld(){
		return eleFirstNameTxtFld;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_last_name']")
	private WebElement eleLastNameTxtFld;
	public WebElement getEleLastNameTxtFld(){
		return eleLastNameTxtFld;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_email']")
	private WebElement eleEmailIDTxtFld;
	public WebElement getEleEmailIDTxtFld(){
		return eleEmailIDTxtFld;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_mobile']")
	private WebElement eleMobileNumberTxtFld;
	public WebElement getEleMobileNumberTxtFld(){
		return eleMobileNumberTxtFld;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_Spassword']")
	private WebElement elePasswordTxtFld;
	public WebElement getElePasswordTxtFld(){
		return elePasswordTxtFld;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='confirmfld_password']")
	private WebElement eleConfirmPasswordTxtFld;
	public WebElement getEleConfirmPasswordTxtFld(){
		return eleConfirmPasswordTxtFld;
	}
	
	@FindBy(xpath="//div[@id='student']//select[@id='fld_class']")
	private WebElement eleSelectClassLst;
	public WebElement getEleSelectClassLst(){
		return eleSelectClassLst;
	}

	@FindBy(xpath="//div[@id='student']//select[@id='fld_section']")
	private WebElement eleSelectSectionLst;
	public WebElement getEleSelectSectionLst(){
		return eleSelectSectionLst;
	}
	
	@FindBy(xpath="//div[@id='student']//a[text()='Back']")
	private WebElement eleBackLnk;
	public WebElement getEleBackLnk(){
		return eleBackLnk;
	}
	
	
	@FindBy(xpath="//div[@id='student']//button[contains(text(),'Sign Up')]")
	private WebElement eleStudentSubmitBtn;
	public WebElement getEleStudentSubmitBtn(){
		return eleStudentSubmitBtn;
	}

	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_first_name']//following-sibling::ul/li[contains(text(),'This value is required.')]")
	private WebElement eleFirstNameErrorMsgThisFldReqrdTxt;
	public WebElement getEleFirstNameErrorMsgThisFldReqrdTxt(){
		return eleFirstNameErrorMsgThisFldReqrdTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_last_name']//following-sibling::ul/li[contains(text(),'This value is required.')]")
	private WebElement eleLastNameErrorMsgThisFieldReqrdTxt;
	public WebElement getEleLastNameErrorMsgThisFieldReqrdTxt(){
		return eleLastNameErrorMsgThisFieldReqrdTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_email']//following-sibling::ul/li[contains(text(),'This value is required.')]")
	private WebElement eleEmailIdErrorMsgThisFieldReqrdTxt;
	public WebElement getEleEmailIdErrorMsgThisFieldReqrdTxt(){
		return eleEmailIdErrorMsgThisFieldReqrdTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_Spassword']//following-sibling::ul/li[contains(text(),'This value is required.')]")
	private WebElement elePasswordErrorMsgThisFieldReqrdTxt;
	public WebElement getElePasswordErrorMsgThisFieldReqrdTxt(){
		return elePasswordErrorMsgThisFieldReqrdTxt;
	}
	

	@FindBy(xpath="//div[@id='student']//input[@id='confirmfld_password']//following-sibling::ul/li[contains(text(),'This value is required.')]")
	private WebElement eleConfirmPswdErrorMsgThisFieldReqrdTxt;
	public WebElement getEleConfirmPswdErrorMsgThisFieldReqrdTxt(){
		return eleConfirmPswdErrorMsgThisFieldReqrdTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//select[@id='fld_class']//following-sibling::ul/li[contains(text(),'This value is required.')]")
	private WebElement eleSelectClassErrorMsgThisFieldReqrdTxt;
	public WebElement getEleSelectClassErrorMsgThisFieldReqrdTxt(){
		return eleSelectClassErrorMsgThisFieldReqrdTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//select[@id='fld_section']//following-sibling::ul/li[contains(text(),'This value is required.')]")
	private WebElement eleSectionErrorMsgThisFieldReqrdTxt;
	public WebElement getEleSectionErrorMsgThisFieldReqrdTxt(){
		return eleSectionErrorMsgThisFieldReqrdTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_email']//following-sibling::ul/li[contains(text(),'This value should be a valid email.')]")
	private WebElement eleEmailIdErrorMsgValidEmailIdTxt;
	public WebElement getEleEmailIdErrorMsgValidEmailIdTxt(){
		return eleEmailIdErrorMsgValidEmailIdTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_mobile']//following-sibling::ul/li[contains(text(),'This value should be a valid phone number.')]")
	private WebElement eleMobNumberErrorMsgValidPhNoTxt;
	public WebElement getEleMobNumberErrorMsgValidPhNoTxt(){
		return eleMobNumberErrorMsgValidPhNoTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_Spassword']//following-sibling::ul/li[1]")
	private WebElement elePwdFldErrorMsgTxt;
	public WebElement getElePwdFldErrorMsgAlphanumericTxt(){
		return elePwdFldErrorMsgTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='fld_Spassword']//following-sibling::ul/li[2]")
	private WebElement elePwdFldErrorMsgValueIsTooShortTxt;
	public WebElement getElePwdFldErrorMsgValueIsTooShortTxt(){
		return 
				elePwdFldErrorMsgValueIsTooShortTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='confirmfld_password']//following-sibling::ul/li[1]")
	private WebElement eleConfirmPwdFldErrorMsgTxt;
	public WebElement getEleConfirmPwdFldErrorMsgAlphanumericTxt(){
		return eleConfirmPwdFldErrorMsgTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//input[@id='confirmfld_password']//following-sibling::ul/li[2]")
	private WebElement eleConfirmPwdFldErrorMsgValueIsTooShortTxt;
	public WebElement getEleConfirmPwdFldErrorMsgValueIsTooShortTxt(){
		return eleConfirmPwdFldErrorMsgValueIsTooShortTxt;
	}
	
	@FindBy(xpath="//div[@id='student']//button[text()='Sign Up']")
	private WebElement eleSignUpBtn;
	public WebElement getEleSignUpBtn(){
		return eleSignUpBtn;
	}
	@FindBy(xpath="//p[contains(text(),'Login Id :')]")
	private WebElement eleNewLoginIDTxt;
	public WebElement getEleNewLoginIDTxt(){
		return eleNewLoginIDTxt;
	}
	
	
	@FindBy(xpath="//a[@class='blueText']")
	private WebElement eleClickHereLnk;
	public WebElement getEleClickHereLnk(){
		return eleClickHereLnk;
	}
	public void newStudentLoginId() throws InterruptedException
	{
		String[] newLoginId=getEleNewLoginIDTxt().getText().split(" ");
	    System.out.println(newLoginId[3]);
	    Thread.sleep(1000);
	    GenericLib.setCongigValue(GenericLib.sConfigFile,"STUDENTLOGINID",newLoginId[3]);
	    Thread.sleep(1000);
	}
}
