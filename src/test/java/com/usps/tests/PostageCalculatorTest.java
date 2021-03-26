package com.usps.tests;


import com.tests.BaseTest;
import com.tests.BaseTestLastStage;
import com.usps.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PostageCalculatorTest extends BaseTest {


    private char packageLength;
    private char packageHeight;
    private char packageWidth;



    @Parameters({"packageLength", "packageHeight", "packageWidth"})
    public  void setupParameters(char packageLength, char packageHeight, char packageWidth){


        this.packageLength = packageLength;
        this.packageHeight = packageHeight;
        this.packageWidth = packageWidth;
    }

    @Test
    public void destinationPackagePage(){
        PostageCalculatorDestinationPage destinationPage = new PostageCalculatorDestinationPage(driver);
        destinationPage.goTo();
        destinationPage.enterDestinationDetails(78727, 94107);
        destinationPage.submit();
    }

    @Test(dependsOnMethods = "destinationPackagePage")
    public void packageWeightPage(){
        PackageWeightPage packageWeightPage = new PackageWeightPage(driver);
        packageWeightPage.enterPackageWeight(25,0);
        packageWeightPage.submit();


    }

    @Test(dependsOnMethods = "packageWeightPage")
    public void packagePropertiesPage(){
        LargePackagePropertiesPage packagePropertiesPage = new LargePackagePropertiesPage(driver);
        packagePropertiesPage.enterPackageLenght(packageLength);
        packagePropertiesPage.enterPackageLenght(packageHeight);
        packagePropertiesPage.enterPackageLenght(packageWidth);
        packagePropertiesPage.submit();

    }

    @Test(dependsOnMethods = "packagePropertiesPage")
    public void mailServicesOptionsPrices(){
        MailServicesOptionsPage mailServicesOptionsPrices = new MailServicesOptionsPage(driver);
        boolean actualPrice = mailServicesOptionsPrices.getPrice();
        Assert.assertTrue(actualPrice);
        boolean imagePresented = mailServicesOptionsPrices.isImagePresented();
        Assert.assertTrue(imagePresented);
    }



}
