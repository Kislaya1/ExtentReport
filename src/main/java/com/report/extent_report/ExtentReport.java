package com.report.extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
    private ExtentReport() {}
    private static ExtentReports extent; // Specify the location of the report
    private static ExtentTest test; // what details needs to be populated in report

    public static void initReports() {
        extent = new ExtentReports();
    }
}
