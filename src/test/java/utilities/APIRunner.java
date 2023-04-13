package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIRunner {
    private static CustomResponse customResponse;
    private static CustomResponse [] responseList;
    public static void runGET(String path){
        String token = Config.getValue("cashwiseToken");
        String url = Config.getValue("cashwiseBackend") + path;
        Response response = RestAssured.given().auth().oauth2(token).get(url);
        System.out.println("Status: " + response.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        try {
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
            customResponse.setJsonString(response.asString());
            customResponse.setStatusCode(response.statusCode());
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't convert JSON to CustomResponse");
        }
    }

    public static void runGetList(String path){
        String token = Config.getValue("cashwiseToken");
        String url = Config.getValue("cashwiseBackend") + path;
        Response response = RestAssured.given().auth().oauth2(token).get(url);
        System.out.println("Status: " + response.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        try {
            responseList = mapper.readValue(response.asString(), CustomResponse[].class);
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't convert JSON to CustomResponse");
        }
    }

    public static CustomResponse[] getResponseList(){
        return responseList;
    }

    public static CustomResponse getCustomResponse(){
        return customResponse;
    }


}

