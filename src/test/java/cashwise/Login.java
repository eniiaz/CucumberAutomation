package cashwise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Login {

    @Test
    public void authorization(){
        String body = "{\n" +
                "  \"email\": \"test@tester.com\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(body).post("https://backend.cashwise.us/api/myaccount/auth/login");
        System.out.println(response.statusCode());
        System.out.println();
        System.out.println(response.asString());
    }

    @Test
    public void getIncomeCategories(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODEzMjUwMzcsImlhdCI6MTY4MDcyMDIzN30.nAtvp_TnQJsKSj_oF9QsfrD_h9tCzH__D6fkZseHfLm5mgAVVFD0CWim_jlPGqxhS20SreCQ0UdQJkTJ0J7sRQ";

        Response response =  RestAssured.given().contentType(ContentType.JSON).auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/categories/income");

        System.out.println(response.statusCode());

        for (int i = 0; i < 61; i++){
            String path = "[" + i + "].flag";
            boolean flag = response.jsonPath().get(path);
            Assert.assertTrue(flag);
            String path2 = "[" + i + "].category_title";
            String title = response.jsonPath().get(path2);
            if (title.trim().isEmpty()){
                System.out.println("Found at: " + i);
            }
        }


    }


    @Test
    public void reqResCreate(){
        String body = "{\n" +
                "    \"name\": \"Chicago\",\n" +
                "    \"job\": \"cashier\"\n" +
                "}";

        Response response = RestAssured.given().contentType(ContentType.JSON).body(body).post("https://reqres.in/api/users");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

}
