package tests;

import org.hamcrest.Matcher;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class testExamples

{
		
@Test
public void testGetAllPosts() 
{
	// test all posts
	baseURI = "https://jsonplaceholder.typicode.com/posts";
	 given().
	     get(baseURI).
	 
	 then().
	      statusCode(200).
	      
	      body("body[4]", equalTo("repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"));
	 
   }
   

@Test
public void testGetPostById()
   
   {
	
	baseURI = "https://jsonplaceholder.typicode.com/posts";	
	given().
	     get("/?id=2").
	then().    
	     statusCode(200).
	     
	    body("body[0]", equalTo("est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"));
   }



@Test
public void testPost()
   {
	
	Map<String,Object> map = new HashMap<String,Object>();
	
    JSONObject request = new JSONObject();
    request.put("title","foo");   
    request.put("body","bar");
    request.put("userId", 1);

      baseURI="https://jsonplaceholder.typicode.com";
    given().
       body(request.toJSONString()).
    when().
       post("/posts").
    then().
       statusCode(201);
      
    

   }

   }




   
  
