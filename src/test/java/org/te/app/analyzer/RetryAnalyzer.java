package org.te.app.analyzer;

import org.te.app.android.AppConstants.AppConstants;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    public int retryCount =0;
    public int maxRetry = AppConstants.numberOfRetries;

    @Override
    public boolean retry(ITestResult iTestResult) {
        retryCount++;
        return retryCount < maxRetry;
    }

}
