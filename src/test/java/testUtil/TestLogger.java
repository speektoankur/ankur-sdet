package testUtil;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestLogger implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Reporter.log(iTestResult.getMethod().getMethodName() + " Test Started ");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log(iTestResult.getMethod().getMethodName() + " Test Succeeded ");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Reporter.log(iTestResult.getMethod().getMethodName() + " Test Failed",1);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.log(iTestResult.getMethod().getMethodName() + " Test Skipped ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Reporter.log(iTestResult.getMethod().getMethodName() + " Test Partially Failed ",2);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Reporter.log(iTestContext.getName() + " Test Started ");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Reporter.log(iTestContext.getName() + " Test Finished ");
    }
}
