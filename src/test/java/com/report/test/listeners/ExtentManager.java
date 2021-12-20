package com.report.test.listeners;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
  private static final ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

  private ExtentManager() {}

  static ExtentTest getTest() {
    return exTest.get();
  }

  static void setTest(ExtentTest test) {
    exTest.set(test);
  }
}
