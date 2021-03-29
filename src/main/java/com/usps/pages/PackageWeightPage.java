package com.usps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PackageWeightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='Pounds']")
    private WebElement poundsTxt;

    @FindBy(xpath = "//input[@name='Ounces']")
    private WebElement ouncesTxt;

    @FindBy(xpath = "//input[@value='LargePackage']")
    private WebElement largePackageBtn;




    public PackageWeightPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }



    public void enterPackageWeight(int pounds, int ounces){

        this.wait.until(ExpectedConditions.elementToBeClickable(this.largePackageBtn));
        this.poundsTxt.click();
        this.poundsTxt.sendKeys(""+pounds);
        this.ouncesTxt.click();
        this.ouncesTxt.sendKeys(""+ounces);
    }


    public void submit(){
        this.largePackageBtn.click();
    }



}
