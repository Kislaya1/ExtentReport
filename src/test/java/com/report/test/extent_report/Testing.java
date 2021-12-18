package com.report.test.extent_report;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing extends BaseTest {

  @Test
  public void scenario1() {
    System.out.println("Inside Scenario 1 ");
    Assert.assertEquals(true, false);
  }

  @Test
  public void scenario2() {
    System.out.println("Inside Scenario 2 ");
    Assert.assertEquals(true, true);
  }
}
