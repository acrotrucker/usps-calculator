package com.usps.tests;



import com.tests.BaseTest;
import com.usps.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class PostageCalculatorTest extends BaseTest {


    public String packageLength;
    public String  packageHeight;
    public String packageWidth;


    @BeforeTest
    @Parameters({"packageLength", "packageHeight", "packageWidth"})
    public   void setupParameters(String  packageLength, String packageHeight, String packageWidth){


        this.packageLength = packageLength;
        this.packageHeight = packageHeight;
        this.packageWidth = packageWidth;
    }

    @Test
    public void destinationPackagePage() {
        PostageCalculatorDestinationPage destinationPage = new PostageCalculatorDestinationPage(driver);
        destinationPage.goTo();
        destinationPage.enterDestinationDetails(78727, 94107);
        destinationPage.submit();
    }

    @Test(dependsOnMethods = "destinationPackagePage")
    public void packageWeightPage() {
        PackageWeightPage packageWeightPage = new PackageWeightPage(driver);
        packageWeightPage.enterPackageWeight(25, 0);
        packageWeightPage.submit();


    }


    @Test(dependsOnMethods = "packageWeightPage")
    public void packagePropertiesPage() {
        LargePackagePropertiesPage packagePropertiesPage = new LargePackagePropertiesPage(driver);
        packagePropertiesPage.enterPackageProperties(packageLength,packageHeight,packageWidth);
        packagePropertiesPage.submit();

    }

    @Test(dependsOnMethods = "packagePropertiesPage")
    public void mailServicesOptionsPrices() {
        MailServicesOptionsPage mailServicesOptionsPrices = new MailServicesOptionsPage(driver);
        boolean actualPrice = mailServicesOptionsPrices.getPrice();
        Assert.assertTrue(actualPrice);
        boolean imagePresented = mailServicesOptionsPrices.isImagePresented();
        Assert.assertTrue(imagePresented);
    }

}