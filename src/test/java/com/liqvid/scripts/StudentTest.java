/***********************************************************************
 * @module			:		Student Test
 * @description		: 		Test scripts of StudentValidation 
 * @testmethod		:	   	uploadStudentPhoto()
 * @testmethod		:	   	studentStartCourse()  
 */


package com.liqvid.scripts;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.po.LaunchStudentCoursePO;
import com.liqvid.po.LoginPO;
import com.liqvid.po.StudentCourseSessionPO;
import com.liqvid.po.StudentHomePO;

public class StudentTest extends BaseLib {

	StudentHomePO studentHomePo = null;
	LoginPO loginPo = null;
	LaunchStudentCoursePO launchStudentCoursePo = null;
	StudentCourseSessionPO studentCourseSessionPo =null;
	public static String sStudentUploadPhoto = GenericLib.sDirPath+"\\resources\\StudentPhotoUpload.exe";
	
	/* 
	 * @Description: Login as Student and add a photo of the student. 
	 * @Author:Kirthana SS
	 */
	
	@Test(priority=1,enabled=false, description="Login as Student and add a photo of the student.")
	public void uploadStudentPhoto() throws Exception
	{
		try
		{
			loginPo = new LoginPO(driver);
			studentHomePo =new StudentHomePO(driver);
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			GenericLib.studentLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "STUDENTLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile, "STUDENTPASSWORD"));
			studentHomePo.getEleHomeLnk().click();
			Assert.assertTrue(studentHomePo.getStudentPaneltxt().isDisplayed(), "Student Panel Text is not displayed");
			NXGReports.addStep("Student Panel Text is displayed", LogAs.PASSED, null);	
			studentHomePo.getStudentProfilePhoto().click();
			studentHomePo.getBrowseBtn().click();
			Thread.sleep(1000);
			Runtime.getRuntime().exec(sStudentUploadPhoto);
			Thread.sleep(10000);
			studentHomePo.getSubmitBtn().click();
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	
	/* 
	 * @Description: Login with valid credentials as student, start a course for a class and open session1. Verify the Title text. 
	 * @Author:Kirthana SS
	 */
	@Test(priority=2,enabled=true, description="Login with valid credentials as student, start a course, open session1. Verify the Title text.")
	public void studentStartCourse() throws Exception
	{
		try
		{
			loginPo = new LoginPO(driver);
			studentHomePo =new StudentHomePO(driver);
			launchStudentCoursePo=new LaunchStudentCoursePO(driver);
			studentCourseSessionPo=new StudentCourseSessionPO(driver);
			
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"REGISTRATIONURL"));
			GenericLib.studentLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "STUDENTLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile,"STUDENTPASSWORD"));
			Assert.assertTrue(studentHomePo.getEnglishEdgeLogo().isDisplayed(),"Student HomePage is not Displayed");
			NXGReports.addStep("Student HomePage is Displayed", LogAs.PASSED, null);
			studentHomePo.getMyCoursesLnk().click();
			Assert.assertTrue(launchStudentCoursePo.getLearningTxt().isDisplayed(),"Launch student Course page is not displayed");
			NXGReports.addStep("Launch student Course page is displayed", LogAs.PASSED, null);
			launchStudentCoursePo.getClass1SectionABtn().click();
			launchStudentCoursePo.getCourse1Btn().click();
			launchStudentCoursePo.getStartCourseBtn().click();
			Assert.assertTrue(studentCourseSessionPo.getiframe().isDisplayed(),"Student Course map is not displayed");
			NXGReports.addStep("Student Course map is displayed", LogAs.PASSED, null);
            driver.switchTo().frame(studentCourseSessionPo.getiframe());
            studentCourseSessionPo.getSession1lnk().click();;
            Set<String> allWindows=driver.getWindowHandles();
	        Iterator<String> it = allWindows.iterator();
	        String parentWindowId = it.next();
	        String childWindowId = it.next();
	        driver.switchTo().window(childWindowId);
	        driver=  driver.switchTo().frame("fraheader");
	        studentCourseSessionPo=new StudentCourseSessionPO(driver);
	      	Assert.assertTrue(studentCourseSessionPo.getGoatEaterTitle().isDisplayed(),"The goat – eater is not displayed");
	        NXGReports.addStep("The goat – eater is displayed", LogAs.PASSED, null);
	        studentCourseSessionPo.getEleExitBtn().click();
	        driver.switchTo().window(parentWindowId);
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
}
	
	
	

