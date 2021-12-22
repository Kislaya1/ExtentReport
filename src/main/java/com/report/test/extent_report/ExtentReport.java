package com.report.test.extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import tech.grasshopper.reporter.ExtentPDFReporter;

import java.io.File;
import java.io.IOException;

public final class ExtentReport {
  private static final String OUTPUT_FOLDER = "/report-output/",
      REPORT_FILE_NAME = "report.html",
      PDF_FILE_NAME = "report.pdf",
      PROJECT_NAME = "MyProject",
      XML_CONFIG_FILE_PATH = "/src/test/resources/extent/pdf-config.xml",
      JSON_CONFIG_FILE_PATH = "/src/test/resources/extent/pdf-config.json";
  private static final String
      reportFile = System.getProperty("user.dir") + OUTPUT_FOLDER + REPORT_FILE_NAME,
      reportPdfFile = System.getProperty("user.dir") + OUTPUT_FOLDER + PDF_FILE_NAME,
      xmlConfigFile = System.getProperty("user.dir") + XML_CONFIG_FILE_PATH,
      jsonConfigFile = System.getProperty("user.dir") + JSON_CONFIG_FILE_PATH;
  private static ExtentReports extentReports;
  private static ExtentTest test;

  private ExtentReport() {}

  public static synchronized void initReport() throws IOException {
    create_dir();
    extentReports = new ExtentReports();
    ExtentPDFReporter pdf = new ExtentPDFReporter(reportPdfFile);
    pdf.loadXMLConfig(xmlConfigFile);
    //pdf.loadJSONConfig(jsonConfigFile);
    ExtentSparkReporter spark = new ExtentSparkReporter(reportFile);
    ExtentKlovReporter klov = new ExtentKlovReporter(PROJECT_NAME).initWithDefaultSettings();
    extentReports.attachReporter(spark, klov, pdf);
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
