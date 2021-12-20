package com.report.test.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {
  private static ExtentReports extentReports;
  private static ExtentTest test;

  private ExtentReport() {}

  public synchronized static void initReport() {
    extentReports = new ExtentReports();
    ExtentSparkReporter spark =
        new ExtentSparkReporter(System.getProperty("user.dir") + "/report-output/index.html");
    ExtentKlovReporter klov = new ExtentKlovReporter("MyProject").initWithDefaultSettings();
    extentReports.attachReporter(spark, klov);
  }

  public synchronized static void createTest(String testName) {
    test = extentReports.createTest("My test : " + testName);
    ExtentManager.setTest(test);
  }

  public synchronized static void tearDownReport() {
    extentReports.flush();
  }
}
