package com.report.test.extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.KlovReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  public static ExtentReports extentReports; // Specify the location of the report

  private static String getTestMethodName(ITestResult iTestResult) {
    return iTestResult.getMethod().getConstructorOrMethod().getName();
  }

  @BeforeClass
  public void setup() {
    KlovReporter klovReporter = new KlovReporter();
    klovReporter.initMongoDbConnection("localhost", 27017);
    klovReporter.setProjectName("Kislaya : Klov Reporter");
    klovReporter.setReportName("1.4");
    klovReporter.setKlovUrl("http://localhost");
    extentReports = new ExtentReports();
    extentReports.attachReporter(klovReporter);
  }

  @AfterClass
  public void tearDown() {
    extentReports.flush();
  }
}
