package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PutPatchDeleteExample {
	
	@Test(priority=1)
	public void testPost(){
		
		JSONObject request= new JSONObject();
		request.put("name", "Sushant");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
	   
		given().
		header("Content_Type", "Application/JSON").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		post("/users").
	then().
		statusCode(201).log().all();
		
				
	}
	
	@Test(priority=2)
	public void testPatch(){
		JSONObject request= new JSONObject();
		
		request.put("name", "Deepakroy");
		request.put("Job", "IT");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("Content_Type", "Application/JSON").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		patch("/users/2").
	then().
		statusCode(200).log().all();
			
	}
	
	@Test(priority=3)
	public void testDelete(){
		
		baseURI = "https://reqres.in/api";
		
		when(). 
			delete("/users/2"). then().
			statusCode(204).log().all();
				
		
	}
}
