package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {
    public static ExtentReports extentReports = ExtentSetup.setupExtentReport();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        System.out.println("From: " + result.getTestClass().getName() + " The test " + result.getMethod().getMethodName() + " started");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("From: " + result.getTestClass().getName() +
                "The test " + result.getMethod().getMethodName() + " passed");
        Markup m = MarkupHelper.createLabel("Esto esta chido", ExtentColor.AMBER);
        extentTest.get().log(Status.PASS, m);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("From: " + result.getTestClass().getName() +
                "The test " + result.getMethod().getMethodName() + "failed");
        Markup m = MarkupHelper.createLabel("Esto esta chido", ExtentColor.AMBER);
        extentTest.get().log(Status.FAIL, m);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("From: " + result.getTestClass().getName() +
                "The test " + result.getMethod().getMethodName() + "was skied");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("From: " + result.getTestClass().getName() +
                "The test " + result.getMethod().getMethodName() + "passed");
        Markup m = MarkupHelper.createLabel("Esto esta chido", ExtentColor.AMBER);
        extentTest.get().log(Status.FAIL, m);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("probando flush");
        extentReports.flush();
    }
}
