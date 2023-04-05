package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import utilities.MyLogger;
import java.util.Random;

public class Table {

    @Test
    public void api() throws JsonProcessingException {
        Response response = RestAssured.given().get("https://reqres.in/api/users?page=2");

        String res = response.asString();
       // System.out.println(res);
        ObjectMapper objectMapper = new ObjectMapper();
        CustomResponse customResponse = objectMapper.readValue(res, CustomResponse.class);

        for (User user: customResponse.data){
            System.out.println(user.email);
        }

    }

}
