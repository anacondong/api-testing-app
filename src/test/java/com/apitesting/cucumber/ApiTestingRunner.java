package com.apitesting.cucumber;

import com.apitesting.testbase.TestBase;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/")
public class ApiTestingRunner extends TestBase {


}
