package com.liqvid.library;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;


public class BaseLib {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		try{
		if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\chromedriver.exe");
			System.out.println("Chrome Browser is set");
			driver = new ChromeDriver();
		}else if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\geckodriver.exe");
			System.out.println("Firefox Browser is set");
			driver = new FirefoxDriver();
		}
		else{
			System.setProperty("webdriver.ie.driver", GenericLib.sDirPath+"\\resources\\IEDriverServer.exe");
			System.out.println("InternetExplorer Browser is set");
			driver = new InternetExplorerDriver();
		}
		NXGReports.setWebDriver(driver);
		}
		catch(Exception e){
			System.out.println("Problem in launching driver");
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	public void loadURL(String sUrl)
	{
		try{
			driver.get(sUrl);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(AssertionError e){
			NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}	
	}


}
