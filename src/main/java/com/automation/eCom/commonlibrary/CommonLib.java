package com.automation.eCom.commonlibrary;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonLib {
	public WebDriver driver;
	protected WebElement webElement;
	protected XSSFWorkbook wb;
	protected XSSFSheet sheet;
	protected int rowCount;
	protected int rowsCount;
	protected Properties prop;
	protected ExtentReports eReport;
	protected ExtentTest eTest;
	
	public  CommonLib() {
		eReport= new ExtentReports("src/test/java/com/automation/eCom/TestReports/RegisterReport.html");
	}
	@BeforeTest
 	@Parameters({"Browser","URL"})
	public void launchBrowser(String browser,String url){
		eTest=eReport.startTest("Register");
 		if(browser.equalsIgnoreCase("FF")){
 			System.setProperty("webdriver.gecko.driver", "src/test/java/com/automation/eCom/utils/geckodriver.exe");
 			driver = new FirefoxDriver();
 		}
 		driver.get(url);
 		if(driver.findElement(By.linkText("Register")).isDisplayed()){
 			eTest.log(LogStatus.PASS, "Browser is launched and Home page is displayed");
 		}else{
 			eTest.log(LogStatus.FAIL, "Browser is not launched or Home page is not displayed");
 		}
 		if(driver.findElement(By.linkText("Register")).isDisplayed()){
 			eTest.log(LogStatus.FAIL, "Register Link Not present");
 		}else{
 			eTest.log(LogStatus.FAIL, "Register Link is not present");
 		}
 		eReport.endTest(eTest);
 		eReport.flush();
 	}
	public void readDataFromInputData(String sName) throws IOException{
		FileInputStream fis = new FileInputStream("src\\test\\java\\org\\data\\InputData.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet= wb.getSheet(sName);
		rowCount = sheet.getLastRowNum();
	}
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}

}
