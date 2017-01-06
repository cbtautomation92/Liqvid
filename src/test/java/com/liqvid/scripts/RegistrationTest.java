
/***********************************************************************
 * @module			:		Registration Test
 * @description		: 		Test scripts of Registration Validation 
 * @testmethod		:	   	validRegistrationCode()
 * @testmethod		:	   	inValidProductKey()
 */

package com.liqvid.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.po.RegistrationPO;

public class RegistrationTest extends BaseLib
{
	RegistrationPO registrationPo = null;
	String invalidProductKey = null;
	String invalidLicenceKey = null;
		
	/* 
	 * @Description: To Verify successful registration and display of sign in page.
	 * @Author:Vinay N
	 */
	@Test(priority=1,enabled=true, description="To Verify successful registration and display of sign in page.")
	public void validRegistrationCode() throws Exception
	{
	
		registrationPo = new RegistrationPO(driver);
		
		try{
			
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "REGISTRATIONURL"));
			registrationPo.getEleIHaveInternetConnectivityRdBtn().click();
			registrationPo.getEleInternetCheckNxtBtn().click();
			Assert.assertTrue(registrationPo.getEleWelcomeToEnglishEdgeHdrTxt().isDisplayed(), "Welcome to EnglishEdge Activation Page is not displayed");
			NXGReports.addStep("Welcome to EnglishEdge Activation Page is displayed", LogAs.PASSED, null);
			registrationPo.getEleEnglishEdgeActvationNxtBtn().click();
			Assert.assertTrue(registrationPo.getEleRegistrationCodeHdrTxt().isDisplayed(), "Registration code Page is not displayed");
			NXGReports.addStep("Registration code Page is displayed", LogAs.PASSED, null);	
			registrationPo.getEleRegistrationCodeTxtFld().click();
			registrationPo.getEleRegistrationCodeTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "PRODUCTKEY"));
			registrationPo.getEleRegistrationCodeSbmtBtn().click();
			Assert.assertTrue(registrationPo.getEleLicenceTxt().isDisplayed(),"Licence key Page is not displayed");
			NXGReports.addStep("Licence key Page is displayed", LogAs.PASSED, null);
			//Valid Licence code step will be added after DB access provided.
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		
	}
	
	
	/* 
	 * @Description: Enter the invalid / non-existing registration code and license key and verify the error message is displayed.   
	 * @Author:Vinay N
	 * 
	 */
	@Test(priority=2,enabled=true, description="Enter the invalid / non-existing registration code and license key and verify the error message is displayed.")
	public void inValidProductKey() throws Exception
	{
	
		registrationPo = new RegistrationPO(driver);
		invalidProductKey = "schmode";
		invalidLicenceKey = "b9990a";
		
		try{
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile, "URL"));
			registrationPo.getEleIHaveInternetConnectivityRdBtn().click();
			registrationPo.getEleInternetCheckNxtBtn().click();
			Assert.assertTrue(registrationPo.getEleWelcomeToEnglishEdgeHdrTxt().isDisplayed(), "Welcome to EnglishEdge Activation Page is not displayed");
			NXGReports.addStep("Welcome to EnglishEdge Activation Page is displayed", LogAs.PASSED, null);
			registrationPo.getEleEnglishEdgeActvationNxtBtn().click();
			Assert.assertTrue(registrationPo.getEleRegistrationCodeHdrTxt().isDisplayed(), "Registration code Page is not displayed");
			NXGReports.addStep("Registration code Page is displayed", LogAs.PASSED, null);	
			registrationPo.getEleRegistrationCodeTxtFld().click();
			registrationPo.getEleRegistrationCodeTxtFld().sendKeys(invalidProductKey);
			registrationPo.getEleRegistrationCodeSbmtBtn().click();
			Assert.assertTrue(registrationPo.getEleErrorMsgForRegistrationCodeTxt().isDisplayed(),"Error message for entering wrong registration code is not displayed");
			NXGReports.addStep("Error message for entering wrong registration code is displayed", LogAs.PASSED, null);
			registrationPo.getEleRegistrationCodeTxtFld().click();
			registrationPo.getEleRegistrationCodeTxtFld().sendKeys(GenericLib.getCongigValue(GenericLib.sConfigFile, "PRODUCTKEY"));
			registrationPo.getEleRegistrationCodeSbmtBtn().click();
			Assert.assertTrue(registrationPo.getEleLicenceTxt().isDisplayed(),"Licence key Page is not displayed");
			NXGReports.addStep("Licence key Page is displayed", LogAs.PASSED, null);
			registrationPo.getEleLicenceKeyTxtFld().click();
			registrationPo.getEleLicenceKeyTxtFld().sendKeys(invalidLicenceKey);
			registrationPo.getEleLicenceKeySbmtBtn().click();
			Assert.assertTrue(registrationPo.getEleErrorMsgForLicenceKeyTxt().isDisplayed(),"Error message for entering wrong licence key is not displayed");
			NXGReports.addStep("Error message for entering wrong licence key is displayed", LogAs.PASSED, null);
				
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
