package com.report.test.extent_report;

import lombok.SneakyThrows;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ISuiteListener, ITestListener {
  @SneakyThrows
  @Override
  public void onStart(ISuite suite) {
    ExtentReport.initReport();
  }

  @Override
  public void onFinish(ISuite suite) {
    ExtentReport.tearDownReport();
  }

  @Override
  public void onTestStart(ITestResult result) {
    ExtentReport.createTest(result.getName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    ExtentManager.getTest().pass("Test Passed");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    ExtentManager.getTest().fail("Test Failed");
  }
}
