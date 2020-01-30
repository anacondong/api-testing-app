package com.apitesting.cucumber.serenity;

import com.apitesting.model.ApiTestingClass;
import com.apitesting.utils.ReuseableSpecifications;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.List;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ApiTestingSerenitySteps {

	@Step("Creating apitest with firstName:{0}, lastName:{1}, email:{2},programme{3} ,courses:{4}")
	public ValidatableResponse createApiTesting(String firstName,String lastName, String email, String programme,
			List<String> courses){
		
		ApiTestingClass apitest = new ApiTestingClass();
		apitest.setFirstName(firstName);
		apitest.setLastName(lastName);
		apitest.setEmail(email);
		apitest.setProgramme(programme);
		apitest.setCourses(courses);
	
	return	SerenityRest.rest().given()
		.spec(ReuseableSpecifications.getGenericRequestSpec())
		.when()
		.body(apitest)
		.post()
		.then();
				
	}
	
	@Step("Getting the apitest information with firstName: {0}")
	public HashMap<String,Object> getApiTestingInfoByFirstName(String firstName){
		String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		
	return	SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path(p1+firstName+p2);
	}
	
	@Step("Updating apitest information with studnetID: {0} firstName:{1}, lastName:{2}, email:{3},programme: {4} ,courses:{5}")
	public  ValidatableResponse updateApiTesting(int apitestid, String firstName,
			String lastName, String email, String programme,
			List<String> courses) {

		ApiTestingClass apitest = new ApiTestingClass();
		apitest.setFirstName(firstName);
		apitest.setLastName(lastName);
		apitest.setEmail(email);
		apitest.setProgramme(programme);
		apitest.setCourses(courses);

		return SerenityRest.rest().given()
				.spec(ReuseableSpecifications.getGenericRequestSpec()).log().all()
				.when().body(apitest).put("/" + apitestid).then();
	}
	
	@Step("Deleting apitest information with ID: {0}")
	public  void deleteApiTesting(int apitestId) {
		SerenityRest.rest().given().when().delete("/" + apitestId);
	}
	

	@Step("Getting information of the apitest with ID: {0}")
	public ValidatableResponse getApiTestingById(int apitestId){
		return 
		SerenityRest
		.rest()
		.given()
		.when()
		.get("/" + apitestId).then();
		
	}
	@Step
	public HashMap<String, Object> getApiTestingInfoByEmailId(String email) {

		String p1 = "findAll{it.email=='";
		String p2 = "'}.get(0)";
		return SerenityRest
				.rest().given().when().get("/list").then().extract()
				.path(p1 + email + p2);
	}
}
