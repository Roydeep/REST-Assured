package test;

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

public class GetAndPostExample {
	
//	@Test
	public void testGet() {
		
		// baseURI = "https://reqres.in/ap";
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George","Rachel"));
	}
		
		@Test
		public void testPost(){
			
			//Map<String, Object> map= new HashMap<String, Object>();
			//map.put("name", "Raghav");
			
			JSONObject request= new JSONObject();
			
			request.put("name", "Deepak");
			request.put("job", "Teacher");
			System.out.println(request.toJSONString());
			
			baseURI= "https://reqres.in/api";
			
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
		
		
	}

