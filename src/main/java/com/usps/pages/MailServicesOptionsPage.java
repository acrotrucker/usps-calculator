package com.usps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailServicesOptionsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//img[@alt='USPS Retail Ground®']")
    private WebElement retailGroundImage;

    @FindBy(xpath = "//*[@id=\"mail-services-sm-lg\"]/div[3]/div[2]/table/tbody/tr/td[3]")
    private WebElement retailGroundPrice;


    public MailServicesOptionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }


    public boolean getPrice() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.retailGroundImage));
        System.out.println(this.retailGroundPrice.getText());
        String price = this.retailGroundPrice.getText();
        double limit = 80.00;
        price = price.replace("$", "");
        double priceValue = Double.parseDouble(price.substring(0,price.indexOf(".")));
        System.out.println("PriceValue : " + priceValue);

        if (priceValue < limit) {
            System.out.println("It is less than $80");
            return true;
        } else {
            System.out.println("It is grater than $80");

        }
        return false;
    }


    public boolean isImagePresented() {

        boolean imagePresent = retailGroundImage.isDisplayed();

        System.out.println("Image presented");

        return imagePresent;
    }
}
