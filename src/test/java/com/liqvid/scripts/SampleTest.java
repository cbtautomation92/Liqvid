package com.liqvid.scripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;

public class SampleTest extends BaseLib  {
	
	@Test(priority=1,enabled=true, description="To Verify the display of Elements in Auditor Login Page")
	public void adminLogin() throws InterruptedException{
		
		
		driver.get("http://10.10.12.189:4001/learning/index.php/site/login");
		driver.findElement(By.id("LoginForm_username")).sendKeys("RaghuKiran-1-71-2");
		driver.findElement(By.id("LoginForm_password")).sendKeys("raghukiran92");
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='contentLogin']/div/div[1]/div[2]/section/div/div[3]/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Courses']")).click();
		
	WebElement element = driver.findElement(By.id("class_select"));
		Select select=new Select(element);
		Thread.sleep(4000);
		select.selectByValue("Class2~~2");
		WebElement element1 = driver.findElement(By.id("course_select"));
		Select select1=new Select(element1);
		select1.selectByVisibleText("Course 2");
		Thread.sleep(4000);
		driver.findElement(By.id("strt")).click();
		Thread.sleep(4000);
		WebElement element2 = driver.findElement(By.xpath("//iframe[@id='iframes']"));
		driver.switchTo().frame(element2);
		driver.findElement(By.xpath(".//*[@id='index']/div/div[4]/a")).click();
		Set<String> allWindows=driver.getWindowHandles();
        Iterator<String> it = allWindows.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
      driver=driver.switchTo().frame(driver.findElement(By.id("frabotbar")));
      Thread.sleep(6000);
      WebElement element3 = driver.findElement(By.id("imgNext"));
      JavascriptExecutor js = (JavascriptExecutor)driver;
      for(int i=1;i<=15;i++){
    	  Thread.sleep(4000);
      js.executeScript("arguments[0].click();", element3);
      }
      driver.switchTo().window(parentWindowId);
        Thread.sleep(6000);
        driver.quit();
		
	}
	@Test(priority=2,enabled=true, description="To Verify the display of Elements in Auditor Login Page")
	public void test1(){
		
	}

}
