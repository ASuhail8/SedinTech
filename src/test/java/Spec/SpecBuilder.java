package Spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import postman.utils.PropertyLoader;

import java.io.IOException;


public class SpecBuilder {
	
	public static RequestSpecification getRequestSpec() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		try {
			return requestSpecBuilder.setBaseUri("https://api.postman.com/workspaces").
					addHeader("x-api-key", PropertyLoader.getProperty("x-api-key")).
					log(LogDetail.ALL).
					build();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static ResponseSpecification getResponseSpec(){
		ResponseSpecBuilder responseSpecBuilder	= new ResponseSpecBuilder();
		return responseSpecBuilder.expectStatusCode(200).expectContentType("application/json; charset=utf-8").
				log(LogDetail.ALL).
				build();
	}
	

}
