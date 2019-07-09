package com.framework.helper;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = "src/test/resources/features", 
					glue = "com.framework.stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{



}
