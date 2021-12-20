package com.report.test.extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public final class ExtentReport {
  private static final String OUTPUT_FOLDER = "/report-output",
      FILE_NAME = "report.html",
      PROJECT_NAME = "MyProject";
  private static ExtentReports extentReports;
  private static ExtentTest test;

  private ExtentReport() {}

  public static synchronized void initReport() {
    create_dir();
    extentReports = new ExtentReports();
    ExtentSparkReporter spark =
        new ExtentSparkReporter(System.getProperty("user.dir") + OUTPUT_FOLDER + FILE_NAME);
    ExtentKlovReporter klov = new ExtentKlovReporter(PROJECT_NAME).initWithDefaultSettings();
    extentReports.attachReporter(spark, klov);
  }

  public static synchronized void createTest(String testName) {
    test = extentReports.createTest("My test : " + testName);
    ExtentManager.setTest(test);
  }

  public static synchronized void tearDownReport() {
    extentReports.flush();
  }

  private static synchronized void create_dir() {
    File reportDir = new File(OUTPUT_FOLDER);
    if (!reportDir.exists() && !reportDir.isDirectory()) reportDir.mkdir();
  }
}
