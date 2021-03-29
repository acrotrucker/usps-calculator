package listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners  implements ITestListener {


    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test started: "+iTestResult.getName());
    }


    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test is passed: "+iTestResult.getName());
    }



    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test FAILED: " + iTestResult.getName()+ " SCREENSHOT will be captured");

    }


    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped: " + iTestResult.getName());
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    public void onStart(ITestContext iTestContext) {

    }


    public void onFinish(ITestContext iTestContext) {

    }

}
