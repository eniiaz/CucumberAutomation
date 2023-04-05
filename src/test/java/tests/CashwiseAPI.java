package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

public class CashwiseAPI {

    @Test
    public void getCategories(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
       // System.out.println(response.asString());
        String data = response.jsonPath().get("data[0].email");
        System.out.println(data);

    }



















    String token;
    @Test
    public void login(){
        String json = "{\n" +
                "  \"email\": \"test@tester.com\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(json).post("https://backend.cashwise.us/api/myaccount/auth/login");
       // System.out.println(response.asString());
         token = response.jsonPath().get("jwt_token");
        System.out.println(token);
    }

    @Test
    public void getMethods(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODEyNTQ4ODQsImlhdCI6MTY4MDY1MDA4NH0.-S7vfUr82Ijyn2J0kBO53ePjUeLChLHcNNWCqTnZNrx8rJr8VHiIRFS0Xyl3A91M2T1XyGsaXn9RASglXRayew";
        Response response = RestAssured.given().auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/bankaccount");
        System.out.println(response.asString());
    }
}
