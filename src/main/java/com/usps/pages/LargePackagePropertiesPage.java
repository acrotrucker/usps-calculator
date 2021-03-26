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

    @FindBy(xpath = "//*[@id=\"Length\"]")
    private  WebElement packageLengthTxt;

    @FindBy(xpath = "//*[@id=\"Height\"]")
    private WebElement packageHeightTxt;

    @FindBy(xpath = "//*[@id=\"Width\"]")
    private WebElement packageWidthTxt;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/form/div[11]/div[1]/div[5]/input")
    private WebElement continueBtn;




    public LargePackagePropertiesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }


    public void enterPackageLenght (char packageLength){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.packageLengthTxt));
        this.packageLengthTxt.click();
        this.packageLengthTxt.sendKeys(""+packageLength);
    }

    public void enterPackageHeight (char packageHeight){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.packageHeightTxt));
        this.packageHeightTxt.click();
        this.packageHeightTxt.sendKeys(""+packageHeight);
    }

    public void enterPackageWidth (char packageWidth){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.packageWidthTxt));
        this.packageWidthTxt.click();
        this.packageWidthTxt.sendKeys(""+packageWidth);
    }
    

    public void submit(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        this.continueBtn.click();
    }



}
