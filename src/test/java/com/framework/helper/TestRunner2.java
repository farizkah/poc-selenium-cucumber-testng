package com.framework.helper;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features/search", glue = "com.framework.stepDefinitions")
public class TestRunner2 extends AbstractTestNGCucumberTests {

}
