package com.qa.testscript;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	FileInputStream fileLoc;
	Properties prop;
	@Parameters({"Browser", "url"})
	@BeforeClass
	public void setUp(String Browser,String url) throws IOException {
		fileLoc = new FileInputStream("E:\\eclipse workspace\\TestAutomation.Amazon\\src\\test\\java\\com\\qa\\testdata\\credentials.properties");
		prop = new Properties();
		prop.load(fileLoc);
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			}
		
driver.get(url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureSS(WebDriver driver,String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/ScreenShots/"+tName+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is captured successfully");
	}
}

