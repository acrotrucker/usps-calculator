package com.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        //set path
        System.setProperty("webdriver.chrome.driver", "/Users/valluchko/IdeaProjects/Java/chromedriver");
        this.driver = new ChromeDriver();
    }
    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}
