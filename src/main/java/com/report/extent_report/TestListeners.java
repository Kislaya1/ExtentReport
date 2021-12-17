package com.report.extent_report;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;


public class TestListeners implements ISuiteListener, ITestListener {
    // ISuiteListeners
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }


}
