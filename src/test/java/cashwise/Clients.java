package cashwise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;
import java.util.HashMap;
import java.util.Map;

public class Clients {

    @Test
    public void getClient(){
        String path = "/api/myaccount/clients/572";
        APIRunner.runGET(path);
        System.out.println(APIRunner.getCustomResponse().getCompany_name());
        System.out.println(APIRunner.getCustomResponse().getClient_name());
        System.out.println(APIRunner.getCustomResponse().getEmail());

        for (int i = 0; i < APIRunner.getCustomResponse().getTags().size(); i++){
            System.out.println(APIRunner.getCustomResponse().getTags().get(i).getNameTag());
            System.out.println(APIRunner.getCustomResponse().getTags().get(i).getCompany().getCompanyName());
        }
    }

    @Test
    public void getClientParam(){
        String path = "https://backend.cashwise.us/api/myaccount/clients";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb2Rld2lzZXIyMDIzQGdtYWlsLmNvbSIsImV4cCI6MTY4MjM0NjQ5NywiaWF0IjoxNjgxNzQxNjk3fQ.lWsezMiEUOFTeRn91VYDAyEqjGztja7VVVxJSYbj90HwPHtoox9s-SuFYbLN8EUncrz1tGNw-bDwVZjn4Q8qQQ";

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 10);
        Response response = RestAssured.given().auth().oauth2(token).params(params).get(path);
        System.out.println(response.asPrettyString());
    }
}