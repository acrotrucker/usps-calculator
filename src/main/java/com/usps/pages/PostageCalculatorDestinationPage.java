package com.usps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostageCalculatorDestinationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "Origin")
    private WebElement fromZIPTxt;

    @FindBy(name = "Destination")
    private WebElement toZIPTxt;

    @FindBy(xpath = "//*[@id=\"ShippingDate\"]")
    private WebElement dateTxt;

    @FindBy(xpath = "//*[@id=\"option_4\"]")
    private WebElement shapeAndSizeBtn;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]/a")
    private WebElement dateChooseTxt;







    public PostageCalculatorDestinationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("https://postcalc.usps.com/");
        this.driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.shapeAndSizeBtn));
    }

    public void enterDestinationDetails(int zipFrom, int zipTo){
        this.fromZIPTxt.click();
        this.fromZIPTxt.sendKeys(""+zipFrom);
        this.toZIPTxt.click();
        this.toZIPTxt.sendKeys(""+zipTo);
        this.dateTxt.click();
        this.dateChooseTxt.click();
    }




    public void submit(){
        this.shapeAndSizeBtn.click();
    }



}
