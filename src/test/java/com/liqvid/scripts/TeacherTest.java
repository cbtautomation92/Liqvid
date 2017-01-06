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
import com.liqvid.po.LaunchTeacherCoursePO;
import com.liqvid.po.LoginPO;
import com.liqvid.po.TeacherCourseSessionPO;
import com.liqvid.po.TeacherHomePO;

public class TeacherTest extends BaseLib{


	/* 
	 * @Description:Login with valid credentials as teacher, start a course, open session1. Verify the Title text. 
	 * @Author:Kirthana SS
	 */
	LoginPO loginPo = null;
	TeacherHomePO teacherHomePo=null;
	LaunchTeacherCoursePO  launchTeacherCoursePo=null;
	TeacherCourseSessionPO teacherCourseSessionPo=null;
	String parentWindowId = null;
	String childWindowId = null;
	Set<String> allWindows = null;
	Iterator<String> iterator = null;
	
	@Test(priority=1,enabled=true, description="Login with valid credentials as teacher, start a course, open session1. Verify the Title text.")
	public void validProductKey() throws Exception
	{
		try
		{
			loginPo = new LoginPO(driver);
			teacherHomePo=new TeacherHomePO(driver);
			launchTeacherCoursePo=new LaunchTeacherCoursePO(driver);
			teacherCourseSessionPo=new TeacherCourseSessionPO(driver);
			
			loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"ADMINURL"));
			GenericLib.teacherLogin(loginPo,GenericLib.getCongigValue(GenericLib.sConfigFile, "TEACHERLOGINID"),GenericLib.getCongigValue(GenericLib.sConfigFile,"TEACHERPASSWORD"));
		
			Assert.assertTrue(teacherHomePo.getTeacherPanelTxt().isDisplayed(),"Teacher HomePage is not Displayed");
			NXGReports.addStep("Teacher HomePage is Displayed", LogAs.PASSED, null);
			teacherHomePo.getCoursesLnk().click();
			Assert.assertTrue(launchTeacherCoursePo.getLearningTxt().isDisplayed(),"Launch Teacher Course page is not displayed");
			NXGReports.addStep("Launch Teacher Course page is displayed", LogAs.PASSED, null);
			launchTeacherCoursePo.getClass1SectionABtn().click();
			launchTeacherCoursePo.getCourse1Btn().click();
			launchTeacherCoursePo.getStartCourseBtn().click();
			Assert.assertTrue(teacherCourseSessionPo.getiframe().isDisplayed(),"Teacher Course map is not displayed");
			NXGReports.addStep("Teacher Course map is displayed", LogAs.PASSED, null);
            driver.switchTo().frame(teacherCourseSessionPo.getiframe());
            teacherCourseSessionPo.getSession1lnk().click();
            allWindows = driver.getWindowHandles();
            iterator = allWindows.iterator();
	        parentWindowId = iterator.next();
	        childWindowId= iterator.next();
	        driver.switchTo().window(childWindowId);
	        driver=  driver.switchTo().frame("fraheader");
	        teacherCourseSessionPo=new TeacherCourseSessionPO(driver);
	      	Assert.assertTrue(teacherCourseSessionPo.getGoatEaterTitle().isDisplayed(),"The goat – eater is not displayed");
	        NXGReports.addStep("The goat – eater is displayed", LogAs.PASSED, null);
	        teacherCourseSessionPo.getEleExitBtn().click();
	        driver.switchTo().window(parentWindowId);
	           
		}
		catch(AssertionError e)
		{
			NXGReports.addStep("Testcase FAiled.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
	
	
	
	
