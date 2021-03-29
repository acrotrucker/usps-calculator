package com.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public abstract class BaseTest  {

    protected static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            this.driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("safari")){
             System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
             this.driver = new SafariDriver();
        }

    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            Date currentDate = new Date();
            String screenshotDate = currentDate.toString().replace(":", "_").replace(" ", "_");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(scrFile, new File("./screenshots/" + testResult.getName() + "_"
                    + screenshotDate +  ".jpg"));
        }
    }

}



