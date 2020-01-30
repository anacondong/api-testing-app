package com.apitesting.cucumber.steps;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import com.apitesting.cucumber.serenity.ApiTestingSerenitySteps;
import com.apitesting.utils.TestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApiTestingSteps {
	static String email=null;
	
	@Steps
	ApiTestingSerenitySteps steps;

	@When("^User sends a GET request to the list endpoint,they must get back a valid status code 200$")
	public void verify_status_code_200_for_listendpoint(){
		SerenityRest.rest()
		.given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	
	@When("^I create a new apitest by providing the information firstName (.*) lastName (.*) email (.*) programme (.*) courses (.*)$")
	public void createApiTesting(String firstName,String lastName,String _email,String programme,String course){
		List<String> courses = new ArrayList<>();
		courses.add(course);
		 email =TestUtils.getRandomValue()+ _email;
		
		 steps.createApiTesting(firstName, lastName, email, programme, courses)
		 .assertThat()
		 .statusCode(201);
		
	}
	
	@Then("^I verify that the apitest with (.*) is created$")
	public void verifyApiTesting(String emailId){
		HashMap<String, Object> actualValue=	steps.getApiTestingInfoByEmailId(email);
		assertThat(actualValue, hasValue(email));
	}
}
