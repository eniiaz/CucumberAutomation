package cashwise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;

import java.util.HashMap;
import java.util.Map;

public class GetClients {

    @Test
    public void getSomeClients(){
        String url = "https://backend.cashwise.us/api/myaccount/clients";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb2Rld2lzZXIyMDIzQGdtYWlsLmNvbSIsImV4cCI6MTY4MjM0NjQ5NywiaWF0IjoxNjgxNzQxNjk3fQ.lWsezMiEUOFTeRn91VYDAyEqjGztja7VVVxJSYbj90HwPHtoox9s-SuFYbLN8EUncrz1tGNw-bDwVZjn4Q8qQQ";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("isArchived", false);
        parameters.put("page", 1);
        parameters.put("size", 5);

        Response response = RestAssured.given().auth().oauth2(token).params(parameters).get(url);
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }

}
