package com.citiustech.test.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.citiustech.test.CalculatorTest;
import com.citiustech.test.LifecycleTest;

@Suite
//@SelectPackages("com.citiustech.test")
@SelectClasses({LifecycleTest.class, CalculatorTest.class})
public class MyTestSuite {

}
