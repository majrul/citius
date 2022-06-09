package com.citiustech.test.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.citiustech.test")
@IncludeTags("dev")
//@SelectClasses({LifecycleTest.class, CalculatorTest.class})
public class MyTestSuite {

}
