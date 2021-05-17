package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testExample {
	
	@Test
	public void test_01() {
		
		
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content_type"));
		
		int statuscose= response.getStatusCode();
		Assert.assertEquals(statuscose, 200);
		
		
		
		
	}
	
	
}