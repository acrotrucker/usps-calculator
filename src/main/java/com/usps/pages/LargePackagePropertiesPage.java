package com.usps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LargePackagePropertiesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='Length']")
    private  WebElement packageLengthTxt;

    @FindBy(xpath = "//input[@name='Height']")
    private WebElement packageHeightTxt;

    @FindBy(xpath = "//input[@name='Width']")
    private WebElement packageWidthTxt;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;




    public LargePackagePropertiesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }


    public void enterPackageProperties (String packageLength, String packageHeight, String packageWidth){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.packageLengthTxt));
        this.packageLengthTxt.click();
        this.packageLengthTxt.sendKeys(packageLength);
        this.packageHeightTxt.sendKeys(packageHeight);
        this.packageWidthTxt.sendKeys(packageWidth);
    }

    public void submit(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        this.continueBtn.click();
    }



}
