
/***********************************************************************
 * @module			:		Admin Test
 * @description		: 		Test scripts of AdminValidation 
 * @testmethod		:	   	adminValidLogin()
 * @testmethod		:	   	adminInValidLogin()
 * @testmethod		:	   	withOutAddingStudentAndTeacher()
 * @testmethod		:	    registerStudentWithBlankAndInvalidData()
 * @testmethod		:	    registerTeacherWithBlankAndInvalidData()    
 */

package com.liqvid.scripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.po.AdminHomePO;
import com.liqvid.po.BatchReportPO;
import com.liqvid.po.CreateBatchReportPO;
import com.liqvid.po.CreateBatchesPO;
import com.liqvid.po.ForgotPasswordPO;
import com.liqvid.po.LoginPO;
import com.liqvid.po.StudentHomePO;
import com.liqvid.po.StudentRegistrationPO;
import com.liqvid.po.TeacherCoursePO;
import com.liqvid.po.TeacherHomePO;
import com.liqvid.po.TeacherProfilePO;
import com.liqvid.po.TeacherRegistrationPO;

public class AdminTest  extends BaseLib{

	LoginPO loginPo = null;
	AdminHomePO adminHomePo = null;
	BatchReportPO batchReportPo = null;
	String invalidUserName = null;
	String invalidPwd = null;
	Select select = null;
	StudentRegistrationPO studentRegistrationPo = null;
	TeacherRegistrationPO teacherRegistrationPo = null;
	ForgotPasswordPO forgotPasswordPo = null;
	TeacherCoursePO teacherCoursePo=null;
	TeacherHomePO teacherHomePo=null;
	TeacherProfilePO teacherProfilePo = null;
	CreateBatchesPO createBatchesPo = null;
	CreateBatchReportPO createBatchReportPo=null;
	StudentHomePO studentHomePo=null;
	Date currentDate = new Date( );
    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmmssSS");
	String[] validTeacherData={"Tea"+dateFormat.format(currentDate),"Test","automationcbt@gmail.com","9886210381","teacher","teacher"};
	String[] Teacherfor2Classes={"Tea1"+dateFormat.format(currentDate),"Test","automationcbt@gmail.com","9886210381","teacher","teacher"};
	String[] validStudentData={"Stu"+dateFormat.format(currentDate),"Test","automationcbt@gmail.com","9886210381","student","student"};
	
	String[] inValidStudentData={"Test Allan","Smith","#$#%#%","#$%#%","#$","#$"};
	String[] teacherCredentialvalues={"TestJhon","Ford","automationcbt@gmail.com","9886210381","Teacher26","Teacher25","Teacher25"};
	String teacherName=null;
	String teacherLoginID=null;
	String teacherPwd=null;
	String Updatedteachername=null;
	String updatedteacherLoginId=null;
	String updatedteacherPwd=null;
	/* 
	
	/* 
	 * @Description: Login and logout with valid admin credentials and verify it is directed back to home page.
	 * @Author:Vinay N
	 */
	
	@Test(priority=1,enabled=true, description="Login and logout with valid admin credentials and verify it is directed back to home page.")
	public void adminValidLogin() throws Exception
	{
		try
		{
			loginPo = new LoginPO(driver);
			adminHomePo = new AdminHomePO(driver);
			
			
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			GenericLib.adminLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINPASSWORD"));
			Assert.assertTrue(adminHomePo.getEleWelcomeAdminTxt().isDisplayed(),"Welcome Admin Home page is not displayed");
			NXGReports.addStep("Welcome Admin Home page is displayed", LogAs.PASSED, null);
			adminHomePo.getEleLogoutLink().click();
			Assert.assertTrue(loginPo.getEleSignInTxt().isDisplayed(),"SignIn Text is not displayed");
			NXGReports.addStep("SignIn Text is displayed", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}		
	}
	

	/* 
	 * @Description: Login with blank /Invalid admin credentials for username and password and verify all the error message displayed.
	 * @Author:Vinay N
	 */
	
	@Test(priority=2,enabled=false, description="Login with blank /Invalid admin credentials for username and password and verify all the error message displayed.")
	public void adminInValidLogin() throws Exception
	{
		try
		{
			invalidUserName = "schmode1";
			invalidPwd = "123456";
			loginPo = new LoginPO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			loginPo.getEleSignInBtn().click();
			Thread.sleep(1000);
			Assert.assertTrue(loginPo.getEleUserNameCannotBeBlankTxt().isDisplayed(),"UserName cannot be blank text is not displayed");
			NXGReports.addStep("User name cannot be blank text is displayed", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getElePasswordCannotBeBlankTxt().isDisplayed(),"Password cannot be blank is not displayed");
			NXGReports.addStep("Password cannot be blank is displayed", LogAs.PASSED, null);
			GenericLib.adminLogin(loginPo,invalidUserName,invalidPwd);
			Thread.sleep(1000);
			Assert.assertTrue(loginPo.getEleIncorrectUserNameOrPwdTxt().isDisplayed(),"Incorrect User name or password text is not displayed");
			NXGReports.addStep("Incorrect User name or password text is displayed", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: Without Adding a teacher and student for a class, navigate to Batch Report screen, select class, select teacher or student and verify for display the error messages
	 * @Author:Vinay N
	 */
	
	@Test(priority=3,enabled=false, description="Without Adding a teacher and student for a class, navigate to Batch Report screen, select class, select teacher or student and verify for display the error messages")
	public void withOutAddingStudentAndTeacher() throws Exception
	{
		try
		{
			loginPo = new LoginPO(driver);
			adminHomePo = new AdminHomePO(driver);
			batchReportPo = new BatchReportPO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			GenericLib.adminLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINPASSWORD"));
			adminHomePo.getEleBatchReport().click();
			Assert.assertTrue(batchReportPo.getEleBatchReportTxt().isDisplayed(),"Batch Report Page is not displayed");
			NXGReports.addStep("Batch Report Page is displayed", LogAs.PASSED, null);
			select = new Select(batchReportPo.getEleSelectClassDrpDwn());
			select.selectByVisibleText("class3");
			select = new Select(batchReportPo.getEleSelectSectionDrpDwn());
			select.selectByVisibleText("C");
			select = new Select(batchReportPo.getEleSelectUserTypeDrpDwn());
			select.selectByVisibleText("Student");
			batchReportPo.getEleSubmitBtn().click();
			Assert.assertTrue(batchReportPo.getEleThereAreNoUsersTxt().getText().contains("There are no users in class3 - C"),"There are no users in class Text is not displayed");
			NXGReports.addStep("There are no users in class Text is displayed", LogAs.PASSED, null);
			select = new Select(batchReportPo.getEleSelectClassDrpDwn());
			select.selectByVisibleText("class3");
			select = new Select(batchReportPo.getEleSelectSectionDrpDwn());
			select.selectByVisibleText("C");
			select = new Select(batchReportPo.getEleSelectUserTypeDrpDwn());
			select.selectByVisibleText("Teacher");
			batchReportPo.getEleSubmitBtn().click();
			Assert.assertTrue(batchReportPo.getEleThereAreNoUsersTxt().getText().contains("There are no users in class3 - C"),"There are no users in class Text is not displayed");
			NXGReports.addStep("There are no users in class Text is displayed", LogAs.PASSED, null);
			adminHomePo.getEleLogoutLink().click();
			Assert.assertTrue(loginPo.getEleSignInTxt().isDisplayed(),"Admin Not SignOut Successfully");
			NXGReports.addStep("Admin SignOut Successfully", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: Navigate to login screen, register teacher with invalid data, blank data and Numeric data for text fields. Verify the error message is displayed.
	 * @Author:Vinay N
	 */
	
	@Test(priority=4,enabled=false, description="Navigate to login screen, register teacher with invalid data, blank data and Numeric data for text fields. Verify the error message is displayed.")
	public void registerStudentWithBlankAndInvalidData() throws Exception
	{
		try
		{			
			loginPo = new LoginPO(driver);
			adminHomePo = new AdminHomePO(driver);
			studentRegistrationPo = new StudentRegistrationPO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			loginPo.getEleRegistrationLnk().click();
			studentRegistrationPo.getEleStudentLnk().click();
			Assert.assertTrue(studentRegistrationPo.getEleStudentLnk().isDisplayed(),"Student Registration Page is not displayed");
			NXGReports.addStep("Student Registration Page is displayed", LogAs.PASSED, null);
			studentRegistrationPo.getEleStudentSubmitBtn().click();
			Assert.assertTrue(studentRegistrationPo.getEleFirstNameErrorMsgThisFldReqrdTxt().isDisplayed(),"This value is required error message for First name is not displayed");
			NXGReports.addStep("This value is required error message for First name - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleLastNameErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Last name is not displayed");
			NXGReports.addStep("This value is required error message for Last name - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleEmailIdErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for emailId is not displayed");
			NXGReports.addStep("This value is required error message for emailId - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getElePasswordErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Password is not displayed");
			NXGReports.addStep("This value is required error message for Password - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleConfirmPswdErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Confim Password is not displayed");
			NXGReports.addStep("This value is required error message for Confirm Password - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleSelectClassErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Select Class is not displayed");
			NXGReports.addStep("This value is required error message for Select Class - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleSectionErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Section is not displayed");
			NXGReports.addStep("This value is required error message for Section- Error message is displayed.", LogAs.PASSED, null);
			studentRegistrationPo.getEleFirstNameTxtFld().sendKeys(inValidStudentData[0]);
			studentRegistrationPo.getEleLastNameTxtFld().sendKeys(inValidStudentData[1]);
			studentRegistrationPo.getEleEmailIDTxtFld().sendKeys(inValidStudentData[2]);
			studentRegistrationPo.getEleMobileNumberTxtFld().sendKeys(inValidStudentData[3]);
			studentRegistrationPo.getElePasswordTxtFld().sendKeys(inValidStudentData[4]);
			studentRegistrationPo.getEleConfirmPasswordTxtFld().sendKeys(inValidStudentData[5]);
			studentRegistrationPo.getEleStudentSubmitBtn().click();
			Assert.assertTrue(studentRegistrationPo.getEleEmailIdErrorMsgValidEmailIdTxt().isDisplayed(),"This value should be a valid email is not displayed");
			NXGReports.addStep("This value should be a valid email  Error message - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleMobNumberErrorMsgValidPhNoTxt().isDisplayed(),"This value should be a valid phone number is not displayed");
			NXGReports.addStep("This value should be a valid phone number Error message - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertEquals(studentRegistrationPo.getElePwdFldErrorMsgAlphanumericTxt().getText()+" "+studentRegistrationPo.getElePwdFldErrorMsgValueIsTooShortTxt().getText(), "This value is too short. It should have 6 characters or more. This value should be alphanumeric.","This value is too short. It should have 6 characters or more. This value should be alphanumeric. Error message is not displayed.");
			NXGReports.addStep("This value is too short. It should have 6 characters or more. This value should be alphanumeric- Error message is displayed.", LogAs.PASSED, null);
			Assert.assertEquals(studentRegistrationPo.getEleConfirmPwdFldErrorMsgAlphanumericTxt().getText()+" "+studentRegistrationPo.getEleConfirmPwdFldErrorMsgValueIsTooShortTxt().getText(), "This value is too short. It should have 6 characters or more. This value should be alphanumeric.","This value is too short. It should have 6 characters or more. This value should be alphanumeric. Error message is not displayed.");
			NXGReports.addStep("This value is too short. It should have 6 characters or more. This value should be alphanumeric- Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleSelectClassErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Select Class is not displayed");
			NXGReports.addStep("This value is required error message for Select Class - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(studentRegistrationPo.getEleSectionErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Section is not displayed");
			NXGReports.addStep("This value is required error message for Section- Error message is displayed.", LogAs.PASSED, null);
		/*	adminHomePo.getEleLogoutLink().click();
			Assert.assertTrue(loginPo.getEleSignInTxt().isDisplayed(),"Admin Not SignOut Successfully");
			NXGReports.addStep("Admin SignOut Successfully", LogAs.PASSED, null);*/
			
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description:Navigate to login screen, register student with invalid data, blank data and Numeric data for text fields. Verify the error message is displayed.
	 * @Author:Vinay.N
	 */
	
	@Test(priority=5,enabled=false, description="Navigate to login screen, register student with invalid data, blank data and Numeric data for text fields. Verify the error message is displayed.")
	public void registerTeacherWithBlankAndInvalidData() throws Exception
	{
		try
		{			
			loginPo = new LoginPO(driver);
			teacherRegistrationPo = new TeacherRegistrationPO(driver);
			adminHomePo = new AdminHomePO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			loginPo.getEleRegistrationLnk().click();
			Assert.assertTrue(teacherRegistrationPo.getEleTeacherLnk().isDisplayed(),"Teacher Registration Page is not displayed");
			NXGReports.addStep("Teacher Registration Page is displayed", LogAs.PASSED, null);
			teacherRegistrationPo.getEleTeacherSubmitBtn().click();
			Assert.assertTrue(teacherRegistrationPo.getEleFirstNameErrorMsgThisFldReqrdTxt().isDisplayed(),"This value is required error message for First name is not displayed");
			NXGReports.addStep("This value is required error message for First name - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleLastNameErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Last name is not displayed");
			NXGReports.addStep("This value is required error message for Last name - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleEmailIdErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for emailId is not displayed");
			NXGReports.addStep("This value is required error message for emailId - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getElePasswordErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Password is not displayed");
			NXGReports.addStep("This value is required error message for Password - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleConfirmPswdErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Confim Password is not displayed");
			NXGReports.addStep("This value is required error message for Confirm Password - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleSelectClassErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Select Class is not displayed");
			NXGReports.addStep("This value is required error message for Select Class - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleSectionErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Section is not displayed");
			NXGReports.addStep("This value is required error message for Section- Error message is displayed.", LogAs.PASSED, null);
			teacherRegistrationPo.getEleFirstNameTxtFld().sendKeys(inValidStudentData[0]);
			teacherRegistrationPo.getEleLastNameTxtFld().sendKeys(inValidStudentData[1]);
			teacherRegistrationPo.getEleEmailIDTxtFld().sendKeys(inValidStudentData[2]);
			teacherRegistrationPo.getEleMobileNumberTxtFld().sendKeys(inValidStudentData[3]);
			teacherRegistrationPo.getElePasswordTxtFld().sendKeys(inValidStudentData[4]);
			teacherRegistrationPo.getEleConfirmPasswordTxtFld().sendKeys(inValidStudentData[5]);
			Thread.sleep(1000);
			teacherRegistrationPo.getEleTeacherSubmitBtn().click();
			Assert.assertTrue(teacherRegistrationPo.getEleEmailIdErrorMsgValidEmailIdTxt().isDisplayed(),"This value should be a valid email is not displayed");
			NXGReports.addStep("This value should be a valid email  Error message - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleMobNumberErrorMsgValidPhNoTxt().isDisplayed(),"This value should be a valid phone number is not displayed");
			NXGReports.addStep("This value should be a valid phone number Error message - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertEquals(teacherRegistrationPo.getElePwdFldErrorMsgAlphanumericTxt().getText()+" "+teacherRegistrationPo.getElePwdFldErrorMsgValueIsTooShortTxt().getText(), "This value is too short. It should have 6 characters or more. This value should be alphanumeric.","This value is too short. It should have 6 characters or more. This value should be alphanumeric. Error message is not displayed.");
			NXGReports.addStep("This value is too short. It should have 6 characters or more. This value should be alphanumeric- Error message is displayed.", LogAs.PASSED, null);
			Assert.assertEquals(teacherRegistrationPo.getEleConfirmPwdFldErrorMsgAlphanumericTxt().getText()+" "+teacherRegistrationPo.getEleConfirmPwdFldErrorMsgValueIsTooShortTxt().getText(), "This value is too short. It should have 6 characters or more. This value should be alphanumeric.","This value is too short. It should have 6 characters or more. This value should be alphanumeric. Error message is not displayed.");
			NXGReports.addStep("This value is too short. It should have 6 characters or more. This value should be alphanumeric- Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleSelectClassErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Select Class is not displayed");
			NXGReports.addStep("This value is required error message for Select Class - Error message is displayed.", LogAs.PASSED, null);
			Assert.assertTrue(teacherRegistrationPo.getEleSectionErrorMsgThisFieldReqrdTxt().isDisplayed(),"This value is required error message for Section is not displayed");
			NXGReports.addStep("This value is required error message for Section- Error message is displayed.", LogAs.PASSED, null);
		
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: Add a teacher into a batch for 2 classes and verify the teacher is added for both classes.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=6,enabled=false, description="Add a teacher into a batch for 2 classes and verify the teacher is added for both classes.")
	public void addingTeacherIntwoClass() throws Exception
	{	
		try
		{
			teacherCoursePo =new TeacherCoursePO(driver);
			teacherHomePo=new TeacherHomePO(driver);
			teacherRegistrationPo=new TeacherRegistrationPO(driver);
			loginPo = new LoginPO(driver);
			createBatchesPo = new CreateBatchesPO(driver);
			adminHomePo =new AdminHomePO(driver);
			batchReportPo = new BatchReportPO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			loginPo.getEleRegistrationLnk().click();
			Assert.assertTrue(teacherRegistrationPo.getEleTeacherLnk().isDisplayed(),"Teacher Registration Page is not displayed");
			NXGReports.addStep("Teacher Registration Page is displayed", LogAs.PASSED, null);
			Thread.sleep(1000);
			teacherRegistrationPo.getEleFirstNameTxtFld().sendKeys(validTeacherData[0]);
			teacherRegistrationPo.getEleLastNameTxtFld().sendKeys(validTeacherData[1]);
			teacherRegistrationPo.getEleEmailIDTxtFld().sendKeys(validTeacherData[2]);
			teacherRegistrationPo.getEleMobileNumberTxtFld().sendKeys(validTeacherData[3]);
			teacherRegistrationPo.getElePasswordTxtFld().sendKeys(validTeacherData[4]);
			teacherRegistrationPo.getEleConfirmPasswordTxtFld().sendKeys(validTeacherData[5]);
			select = new Select(teacherRegistrationPo.getEleSelectClassLst());
			select.selectByVisibleText("class1");
	        select = new Select(teacherRegistrationPo.getEleSelectSectionLst());
	        select.selectByVisibleText("A");
	        teacherRegistrationPo.getEleAddBtn().click();
	        select = new Select(teacherRegistrationPo.getEleSelectClass2Lst());
			select.selectByVisibleText("class2");
	        select = new Select(teacherRegistrationPo.getEleSelectSection2Lst());
	        select.selectByVisibleText("A");
	        teacherRegistrationPo.getEleBackLnk().click();
	        loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
	        Thread.sleep(3000);
	        Assert.assertTrue(loginPo.getEleUserNameTxtFld().isDisplayed(),"Login page is not displayed");
			NXGReports.addStep("Login page is displayed", LogAs.PASSED, null);
			loginPo.getEleUserNameTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERFOR2CLASSLOGINID"));
			loginPo.getElePasswordTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERPASSWORD"));
			loginPo.getEleSignInBtn().click();
			Thread.sleep(1000);
			Assert.assertTrue(teacherHomePo.getTeacherPanelTxt().isDisplayed(),"Teacher Home page is not displayed");
			NXGReports.addStep("Teacher Home page is displayed", LogAs.PASSED, null);
			teacherHomePo.getCoursesLnk().click();
			Assert.assertTrue(teacherCoursePo.getClass1SectionATxt().isDisplayed(),"Teacher is not added for Class 1-A");
			NXGReports.addStep("Teacher is added for Class 1-A", LogAs.PASSED, null);
			Assert.assertTrue(teacherCoursePo.getClass2SectionKTxt().isDisplayed(),"Teacher is not added for Class 2-k");
			NXGReports.addStep("Teacher is added for Class 2-k", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: Remove batches and verify the batches are removed in Create Batch Screen
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=7,enabled=false, description="Remove batches and verify the batches are removed in Create Batch Screen")
	public void removeBatches() throws Exception
	{	
		try
		{
			loginPo = new LoginPO(driver);
			createBatchesPo = new CreateBatchesPO(driver);
			adminHomePo =new AdminHomePO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			GenericLib.adminLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINPASSWORD"));
			Assert.assertTrue(adminHomePo.getEleWelcomeAdminTxt().isDisplayed(),"Welcome Admin Home page is not displayed");
			NXGReports.addStep("Welcome Admin Home page is displayed", LogAs.PASSED, null);
			createBatchesPo.getEleCreateBatchLnk().click();
			Assert.assertTrue(createBatchesPo.getEleCreateBatchTxt().isDisplayed(),"Create Batch page is not displayed");
			NXGReports.addStep("Create Batch page is displayed", LogAs.PASSED, null);
			createBatchesPo.getEleAddBatchBtn().click();
			createBatchesPo.getEleRemoveBatchBtn().click();		
			Thread.sleep(1000);
			Assert.assertTrue(createBatchesPo.getEleClassOfCreateBatchLst().isDisplayed(),"Remove button is not removed");
			NXGReports.addStep("Remove button is removed", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	
	/* 
	 * @Description: Add the already existing batch for a class and verify the error message “batch already Exist” is displayed and the batch is not added in the application
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=8,enabled=false, description="Add the already existing batch for a class and verify the error message “batch already Exist” is displayed and the batch is not added in the application")
	public void createExistingBatches() throws Exception
	{	
		try
		{
			loginPo = new LoginPO(driver);
			createBatchesPo = new CreateBatchesPO(driver);
			createBatchReportPo=new CreateBatchReportPO(driver);
			adminHomePo =new AdminHomePO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			GenericLib.adminLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "REGISTRATIONLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "REGISTRATIONPASSWORD"));
			Assert.assertTrue(adminHomePo.getEleWelcomeAdminTxt().isDisplayed(),"Welcome Admin Home page is not displayed");
			NXGReports.addStep("Welcome Admin Home page is displayed", LogAs.PASSED, null);
			createBatchesPo.getEleCreateBatchLnk().click();
			Assert.assertTrue(createBatchesPo.getEleCreateBatchTxt().isDisplayed(),"Create Batch page is not displayed");
			NXGReports.addStep("Create Batch page is displayed", LogAs.PASSED, null);
			select = new Select(createBatchesPo.getEleClassLst());
			select.selectByVisibleText("class1");
			select = new Select(createBatchesPo.getEleSectionFromLst());
			select.selectByVisibleText("A");
			select = new Select(createBatchesPo.getEleSectionTillLst());
			select.selectByVisibleText("A");
			createBatchesPo.getEleCreateBtn().click();
			Thread.sleep(1000);
			Assert.assertTrue(createBatchReportPo.getEleBatchAlreadyExistTxt().isDisplayed(),"Batch Already Exist Text is not displayed");
			NXGReports.addStep("Batch Already Exist Text is displayed", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: Create batches and verify the batches listed in Create Batch Report Screen. Verify the batches are present to select in the Batch Report Screen.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=9,enabled=false, description="Create batches and verify the batches listed in Create Batch Report Screen. Verify the batches are present to select in the Batch Report Screen.")
	public void selectBatches() throws Exception
	{	
		try
		{
			loginPo = new LoginPO(driver);
			createBatchesPo = new CreateBatchesPO(driver);
			batchReportPo = new BatchReportPO(driver);
			adminHomePo =new AdminHomePO(driver);
			createBatchReportPo = new CreateBatchReportPO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			GenericLib.adminLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINPASSWORD"));
			Assert.assertTrue(adminHomePo.getEleWelcomeAdminTxt().isDisplayed(),"Welcome Admin Home page is not displayed");
			NXGReports.addStep("Welcome Admin Home page is displayed", LogAs.PASSED, null);
			createBatchesPo.getEleCreateBatchLnk().click();
			Assert.assertTrue(createBatchesPo.getEleCreateBatchTxt().isDisplayed(),"Create Batch page is not displayed");
			NXGReports.addStep("Create Batch page is displayed", LogAs.PASSED, null);
			select = new Select(createBatchesPo.getEleClassLst());
			select.selectByVisibleText("class1");
			select = new Select(createBatchesPo.getEleSectionFromLst());
			select.selectByVisibleText("Z");
			select = new Select(createBatchesPo.getEleSectionTillLst());
			select.selectByVisibleText("Z");
			createBatchesPo.getEleCreateBtn().click();
			Thread.sleep(1000);
			Assert.assertFalse(createBatchReportPo.getEleBatchCreatedTxt().isDisplayed(),"Batch created Text is not displayed");
			NXGReports.addStep("Batch created Text is displayed", LogAs.PASSED, null);
			adminHomePo.getEleBatchReport().click();
			select = new Select(batchReportPo.getEleSelectClassDrpDwn());
			select.selectByVisibleText("class1");
			select = new Select(batchReportPo.getEleSelectSectionDrpDwn());
			select.selectByVisibleText("Z");
			Assert.assertTrue(select.getFirstSelectedOption().equals("Z"),"Batch created Text is not displayed");
			NXGReports.addStep("Batch created Text is displayed", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description: Login with admin Credentials and In Batch Report Screen, select the student option, teacher. Verify registered student’s student Name, Login ID, Password is displayed.
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=10,enabled=false, description="Login with admin Credentials and In Batch Report Screen, select the student option, teacher. Verify registered student’s student Name, Login ID, Password is displayed.")
	public void studentDetailsInBatchReportScreen() throws Exception
	{	studentRegistrationPo=new StudentRegistrationPO(driver);
		try
		{
			loginPo = new LoginPO(driver);
			createBatchesPo = new CreateBatchesPO(driver);
			adminHomePo =new AdminHomePO(driver);
			batchReportPo = new BatchReportPO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			GenericLib.adminLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINPASSWORD"));
			Assert.assertTrue(adminHomePo.getEleWelcomeAdminTxt().isDisplayed(),"Welcome Admin Home page is not displayed");
			NXGReports.addStep("Welcome Admin Home page is displayed", LogAs.PASSED, null);
			adminHomePo.getEleBatchReport().click();
			Assert.assertTrue(batchReportPo.getEleBatchReportTxt().isDisplayed(),"Batch Report Page is not displayed");
			NXGReports.addStep("Batch Report Page is displayed", LogAs.PASSED, null);
			select = new Select(batchReportPo.getEleSelectClassDrpDwn());
			select.selectByVisibleText("class1");
			select = new Select(batchReportPo.getEleSelectSectionDrpDwn());
			select.selectByVisibleText("A");
			select = new Select(batchReportPo.getEleSelectUserTypeDrpDwn());
			select.selectByVisibleText("Student");
			batchReportPo.getEleSubmitBtn().click();	
			Thread.sleep(1000);
			Assert.assertTrue(batchReportPo.getEleStudentNameTxt().isDisplayed(),"Student Name is not displayed");
			NXGReports.addStep("Student Name is displayed", LogAs.PASSED, null);
			Assert.assertTrue(batchReportPo.getEleStudentLoginIDTxt().isDisplayed(),"Student LoginID is not displayed");
			NXGReports.addStep("Student LoginID is displayed", LogAs.PASSED, null);
			Assert.assertTrue(batchReportPo.getEleStudentPasswordTxt().isDisplayed(),"Student Password is not displayed");
			NXGReports.addStep("Student Password is displayed", LogAs.PASSED, null);
			select = new Select(batchReportPo.getEleSelectClassDrpDwn());
			select.selectByVisibleText("class1");
			select = new Select(batchReportPo.getEleSelectSectionDrpDwn());
			select.selectByVisibleText("A");
			select = new Select(batchReportPo.getEleSelectUserTypeDrpDwn());
			select.selectByVisibleText("Teacher");
			batchReportPo.getEleSubmitBtn().click();	
			Thread.sleep(1000);
			Assert.assertTrue(batchReportPo.getEleTeacherNameTxt().isDisplayed(),"Teacher Name is not displayed");
			NXGReports.addStep("Teacher Name is displayed", LogAs.PASSED, null);
			Assert.assertTrue(batchReportPo.getEleTeacherLoginIDTxt().isDisplayed(),"Teacher LoginID is not displayed");
			NXGReports.addStep("Teacher LoginID is displayed", LogAs.PASSED, null);
			Assert.assertTrue(batchReportPo.getEleTeacherPasswordTxt().isDisplayed(),"Teacher Password is not displayed");
			NXGReports.addStep("Teacher Password is displayed", LogAs.PASSED, null);
			adminHomePo.getEleLogoutLink().click();
			Assert.assertTrue(loginPo.getEleSignInTxt().isDisplayed(),"Admin Not SignOut Successfully");
			NXGReports.addStep("Admin SignOut Successfully", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* 
	 * @Description:Click on ‘forgot password’ Link and verify logging with the password received.
	 * @Author: Kirthana SS
	 */
	
	@Test(priority=11,enabled=false, description="Click on ‘forgot password’ Link and verify logging with the password received.")
	public void forgotPassword() throws Exception
	{
		try
		{
			loginPo = new LoginPO(driver);
			forgotPasswordPo=new ForgotPasswordPO(driver);
			
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			forgotPasswordPo.getEleForgotPasswordLnk().click();
			Assert.assertTrue(forgotPasswordPo.getEleContactAdminTxt().isDisplayed(),"To retrieve Student/Teacher password please contact Admin text is not displayed");
			NXGReports.addStep("To retrieve Student/Teacher password please contact Admin text is displayed", LogAs.PASSED, null);
			forgotPasswordPo.getEleClickHereBtn().click();
			Assert.assertTrue(forgotPasswordPo.getEleAdminPasswordResetTxt().isDisplayed(),"Welcome to Admin password Reset Page is not displayed");
			NXGReports.addStep("Welcome to Admin password Reset Page is displayed", LogAs.PASSED, null);
			forgotPasswordPo.getEleLoginIDTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINLOGINID"));
			forgotPasswordPo.getEleSubmitBtn().click();
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}	
	}
	
	
	/* 
	 * @Description: Navigate to login screen, Register as teacher and verify the teacher is added in the application. Verify teacher can be logged-in with valid credentials
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=12,enabled=false, description="Navigate to login screen, Register as teacher and verify the teacher is added in the application. Verify teacher can be logged-in with valid credentials")
	public void registerLoginTeacher() throws Exception
	{	
		try
		{
			teacherHomePo=new TeacherHomePO(driver);
			teacherRegistrationPo=new TeacherRegistrationPO(driver);
			loginPo = new LoginPO(driver);
			createBatchesPo = new CreateBatchesPO(driver);
			adminHomePo =new AdminHomePO(driver);
			batchReportPo = new BatchReportPO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			loginPo.getEleRegistrationLnk().click();
			Thread.sleep(1000);
			Assert.assertTrue(teacherRegistrationPo.getEleFirstNameTxtFld().isDisplayed(),"Teacher Registration Page is not displayed");
			NXGReports.addStep("Teacher Registration Page is displayed", LogAs.PASSED, null);
			teacherRegistrationPo.getEleFirstNameTxtFld().sendKeys(validTeacherData[0]);
			teacherRegistrationPo.getEleLastNameTxtFld().sendKeys(validTeacherData[1]);
			teacherRegistrationPo.getEleEmailIDTxtFld().sendKeys(validTeacherData[2]);
			teacherRegistrationPo.getEleMobileNumberTxtFld().sendKeys(validTeacherData[3]);
			teacherRegistrationPo.getElePasswordTxtFld().sendKeys(validTeacherData[4]);
			teacherRegistrationPo.getEleConfirmPasswordTxtFld().sendKeys(validTeacherData[5]);
			select = new Select(teacherRegistrationPo.getEleSelectClassLst());
			select.selectByVisibleText("class1");
	        select =new Select(teacherRegistrationPo.getEleSelectSectionLst());
	        select.selectByVisibleText("A");
	        teacherRegistrationPo.getEleSignUpBtn().click();
	        teacherRegistrationPo.newLoginId();
	        teacherRegistrationPo.getEleClickHereLnk().click();
	        Assert.assertTrue(loginPo.getEleUserNameTxtFld().isDisplayed(),"Login Page is not displayed");
			NXGReports.addStep("Login Page is displayed", LogAs.PASSED, null);
			Thread.sleep(1000);
			
			GenericLib.teacherLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile,"TEACHERPASSWORD"));
			Thread.sleep(1000);
			Assert.assertTrue(teacherHomePo.verifyNewTeacherUserName(),"Teacher is not Logged in successfully");
			NXGReports.addStep("Teacher is Logged in successfully", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	
	/* 
	 * @Description: Navigate to login screen, Register as student and verify the student is added in the application. Verify the Student can be logged-in with valid credentials
	 * @Author: Jeevaraj SP
	 */
	@Test(priority=13,enabled=false, description="Navigate to login screen, Register as student and verify the student is added in the application. Verify the Student can be logged-in with valid credentials")
	public void registerLoginStudent() throws Exception
	{	
		try
		{
			studentHomePo =new StudentHomePO(driver);
			studentRegistrationPo=new StudentRegistrationPO(driver);
			loginPo = new LoginPO(driver);
	/*		createBatchesPo = new CreateBatchesPO(driver);
			adminHomePo =new AdminHomePO(driver);
			batchReportPo = new BatchReportPO(driver);*/
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			loginPo.getEleRegistrationLnk().click();
			Thread.sleep(1000);
			studentRegistrationPo.getEleStudentLnk().click();
			Assert.assertTrue(studentRegistrationPo.getEleFirstNameTxtFld().isDisplayed(),"Student Registration Page is not displayed");
			NXGReports.addStep("Student Registration Page is displayed", LogAs.PASSED, null);
			studentRegistrationPo.getEleFirstNameTxtFld().sendKeys(validStudentData[0]);
			studentRegistrationPo.getEleLastNameTxtFld().sendKeys(validStudentData[1]);
			studentRegistrationPo.getEleEmailIDTxtFld().sendKeys(validStudentData[2]);
			studentRegistrationPo.getEleMobileNumberTxtFld().sendKeys(validStudentData[3]);
			studentRegistrationPo.getElePasswordTxtFld().sendKeys(validStudentData[4]);
			studentRegistrationPo.getEleConfirmPasswordTxtFld().sendKeys(validStudentData[5]);
			select = new Select(studentRegistrationPo.getEleSelectClassLst());
			select.selectByVisibleText("class1");
	        select =new Select(studentRegistrationPo.getEleSelectSectionLst());
	        select.selectByVisibleText("A");
	        studentRegistrationPo.getEleSignUpBtn().click();
	        studentRegistrationPo.newStudentLoginId();
	        studentRegistrationPo.getEleClickHereLnk().click();
	        Assert.assertTrue(loginPo.getEleUserNameTxtFld().isDisplayed(),"Login Page is not displayed");
			NXGReports.addStep("Login Page is displayed", LogAs.PASSED, null);
			Thread.sleep(1000);
			GenericLib.studentLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "STUDENTLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile,"STUDENTPASSWORD"));
			Thread.sleep(1000);
			Assert.assertTrue(studentHomePo.verifyNewStudentUserName(),"Student is not Logged in successfully");
			NXGReports.addStep("Student is Logged in successfully", LogAs.PASSED, null);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase Failed.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}	
	
	/* 
	 * @Description: Update the Teachers Profile and verify updated details are reflecting in Admin module.
	 * @Author:Kirthana S.S
	 * 
	 */	
	@Test(priority=14,enabled=false, description="Update the Teachers Profile and verify updated details are reflecting in Admin module.")
	public void updateTeachersProfile() throws Exception
	{
		try
		{       
			    loginPo = new LoginPO(driver);
				adminHomePo=new AdminHomePO(driver);
				batchReportPo= new BatchReportPO(driver);
				teacherHomePo=new TeacherHomePO(driver);
				teacherProfilePo=new TeacherProfilePO(driver);
				loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINURL"));
				GenericLib.adminLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINPASSWORD"));
				Assert.assertTrue(adminHomePo.getEleWelcomeAdminTxt().isDisplayed(),"Admin Homepage is not displayed");
				NXGReports.addStep("Admin Homepage page is displayed", LogAs.PASSED, null);
				adminHomePo.getEleBatchReport().click();
				Assert.assertTrue(batchReportPo.getEleBatchReportTxt().isDisplayed(),"Batch Report Page is not displayed");
				NXGReports.addStep("Batch Report Page is displayed", LogAs.PASSED, null);
				select=new Select(batchReportPo.getEleSelectClassDrpDwn());
				select.selectByVisibleText("class1");
				select=new Select(batchReportPo.getEleSelectSectionDrpDwn());
				select.selectByVisibleText("A");
				select=new Select(batchReportPo.getEleSelectUserTypeDrpDwn());
				select.selectByVisibleText("Teacher");
				batchReportPo.getEleSubmitBtn().click();
			    teacherName=batchReportPo.getEleTeacherNameTxt().getText();
				teacherLoginID=batchReportPo.getEleTeacherLoginIDTxt().getText();
				teacherPwd=batchReportPo.getEleTeacherPasswordTxt().getText();
				adminHomePo.getEleLogoutLink().click();
				Assert.assertTrue(loginPo.getEleSignInTxt().isDisplayed(),"SignIn page is not displayed");
				NXGReports.addStep("SignIn page is displayed", LogAs.PASSED, null);
				loginPo.getEleUserNameTxtFld().click();
				loginPo.getEleUserNameTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERLOGINID"));
				loginPo.getElePasswordTxtFld().click();
				loginPo.getElePasswordTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERPASSWORD"));
				loginPo.getEleSignInBtn().click();
				Assert.assertTrue(teacherHomePo.getTeacherPanelTxt().isDisplayed(),"Teacher HomePage is not displayed");
				NXGReports.addStep("Teacher HomePage is displayed", LogAs.PASSED, null);
				teacherHomePo.getEleDropdownLst().click();
				teacherHomePo.getEleProfileLnk().click();
				Assert.assertTrue(teacherProfilePo.getEleProfileTxt().isDisplayed(),"Teacher ProfilePage is not displayed");
				NXGReports.addStep("Teacher ProfilePage is displayed", LogAs.PASSED, null);
				teacherProfilePo.getEleFirstNameTxtFld().clear();
				teacherProfilePo.getEleFirstNameTxtFld().sendKeys(teacherCredentialvalues[0]);
				teacherProfilePo.getEleLastNameTxtFld().clear();
				teacherProfilePo.getEleLastNameTxtFld().sendKeys(teacherCredentialvalues[1]);
				teacherProfilePo.getEleEmailIDTxtFld().clear();
				teacherProfilePo.getEleEmailIDTxtFld().sendKeys(teacherCredentialvalues[2]);
				teacherProfilePo.getElePhoneTxtFld().sendKeys(teacherCredentialvalues[3]);
				teacherProfilePo.getElechPasswordLnk().click();
				teacherProfilePo.getEleOldPasswardTxtFld().sendKeys(teacherCredentialvalues[4]);
				teacherProfilePo.getEleNewPasswardTxtFld().sendKeys(teacherCredentialvalues[5]);
				teacherProfilePo.getEleConfirmNewPasswordTxtFld().sendKeys(teacherCredentialvalues[6]);
				teacherProfilePo.getEleUpdateBtn().click();
				Assert.assertTrue(teacherProfilePo.getEleUpdatedSuccessTxt().isDisplayed(),"Updated Successfully Text message is not displayed");
				NXGReports.addStep("Updated Successfully Text message is displayed", LogAs.PASSED, null);
				teacherHomePo.getEleDropdownLst().click();
				teacherHomePo.getEleLogoutLnk().click();
				loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
				loginPo.getEleUserNameTxtFld().click();
				loginPo.getEleUserNameTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINLOGINID"));
				loginPo.getElePasswordTxtFld().click();
				loginPo.getElePasswordTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "ADMINPASSWORD"));
				loginPo.getEleSignInBtn().click();
				Assert.assertTrue(adminHomePo.getEleWelcomeAdminTxt().isDisplayed(),"Admin Homepage is not displayed");
				NXGReports.addStep("Admin Homepage page is displayed", LogAs.PASSED, null);
				adminHomePo.getEleBatchReport().click();
				Assert.assertTrue(batchReportPo.getEleBatchReportTxt().isDisplayed(),"Batch Report Page is not displayed");
				NXGReports.addStep("Batch Report Page is displayed", LogAs.PASSED, null);
				select=new Select(batchReportPo.getEleSelectClassDrpDwn());
				select.selectByVisibleText("class1");
				select=new Select(batchReportPo.getEleSelectSectionDrpDwn());
				select.selectByVisibleText("A");
				select=new Select(batchReportPo.getEleSelectUserTypeDrpDwn());
				select.selectByVisibleText("Teacher");
				batchReportPo.getEleSubmitBtn().click();
				Updatedteachername=batchReportPo.getEleTeacherNameTxt().getText();
				Assert.assertEquals(teacherName, Updatedteachername, "Updated");
				NXGReports.addStep("Teacher name is updated", LogAs.PASSED, null);
				updatedteacherLoginId=batchReportPo.getEleTeacherLoginIDTxt().getText();
				Assert.assertEquals(teacherLoginID, updatedteacherLoginId, "Updated");
				NXGReports.addStep("Teacher loginID is updated", LogAs.PASSED, null);
				updatedteacherPwd=batchReportPo.getEleTeacherPasswordTxt().getText();
				NXGReports.addStep("Teacher Password is updated", LogAs.PASSED, null);		
		}
		catch(AssertionError e)
		{
				NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
		}		
	}
	
}