package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {

	WebDriver driver = null;
	public LoginPO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='LoginForm_username']")
	private WebElement eleUserNameTxtFld;
	public WebElement getEleUserNameTxtFld(){
		return eleUserNameTxtFld;
	}
//	/LoginForm_username
	@FindBy(xpath="//input[@id='LoginForm_password']")
	private WebElement elePasswordTxtFld;
	public WebElement getElePasswordTxtFld(){
		return elePasswordTxtFld;
	}
	
	@FindBy(xpath="//input[@value='Sign in']")
	private WebElement eleSignInBtn;
	public WebElement getEleSignInBtn(){
		return eleSignInBtn;
	}
	
	@FindBy(xpath="//p[contains(text(),'Sign in')]")
	private WebElement eleSignInTxt;
	public WebElement getEleSignInTxt(){
		return eleSignInTxt;
	}
	
	@FindBy(xpath="//input[@id='LoginForm_username']//following-sibling::div[contains(text(),'Username cannot be blank.')]")
	private WebElement eleUserNameCannotBeBlankTxt;
	public WebElement getEleUserNameCannotBeBlankTxt(){
		return eleUserNameCannotBeBlankTxt;
	}
	
	@FindBy(xpath="//input[@id='LoginForm_password']//following-sibling::div[contains(text(),'Password cannot be blank.')]")
	private WebElement elePasswordCannotBeBlankTxt;
	public WebElement getElePasswordCannotBeBlankTxt(){
		return elePasswordCannotBeBlankTxt;
	}
	
	@FindBy(xpath="//input[@id='LoginForm_password']//following-sibling::div[contains(text(),'Incorrect username or password.')]")
	private WebElement eleIncorrectUserNameOrPwdTxt;
	public WebElement getEleIncorrectUserNameOrPwdTxt(){
		return eleIncorrectUserNameOrPwdTxt;
	}
	
	@FindBy(xpath="//small[contains(text(),'Registration')]")
	private WebElement eleRegistrationLnk;
	public WebElement getEleRegistrationLnk(){
		return eleRegistrationLnk;
	}
}
