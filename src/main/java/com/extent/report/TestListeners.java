package com.extent.report;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListeners implements ISuiteListener, ITestListener {
    // ISuiteListeners
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }


}
