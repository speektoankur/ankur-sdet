package UserInterfaceFunctional.Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Ankur
 */
public class RetryFailed implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetry = 0;

    /**
     * Function to retry Failed test Cases as per maxRetry number of attempts
     * @param iTestResult
     * @return
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetry) {
            retryCount++;
            return true;
        }
        return false;
    }
}
