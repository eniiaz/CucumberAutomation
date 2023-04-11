package cashwise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SellersTest {

    @Test
    public void singleSeller() throws JsonProcessingException {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODE0MDQ4OTEsImlhdCI6MTY4MDgwMDA5MX0.TghNylK521zaf2uRissKyxfgiwZgL6Si6AERSVvZJhyCe7MCik8sCFcjXXhNc4J1RT3X37_BhoRLc5pJDaNQKQ";
        Response response = RestAssured.given().auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/sellers/94");

        Assert.assertEquals("Connecting to API failed", 200, response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse myResponse = mapper.readValue(response.asString(), CustomResponse.class);

        Assert.assertNotNull("Company name is null",myResponse.getCompany_name());
        Assert.assertNotNull(myResponse.getSeller_name());
        Assert.assertFalse(myResponse.getCompany_name().trim().isEmpty());
        Assert.assertFalse(myResponse.getSeller_name().trim().isEmpty());
    }


    @Test
    public void createSellerTest(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODE0MDQ4OTEsImlhdCI6MTY4MDgwMDA5MX0.TghNylK521zaf2uRissKyxfgiwZgL6Si6AERSVvZJhyCe7MCik8sCFcjXXhNc4J1RT3X37_BhoRLc5pJDaNQKQ";
        Faker faker = new Faker();
        String companyName = faker.company().name();
        String sellerName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phoneNum = faker.phoneNumber().cellPhone();
        String address = faker.address().city();

        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name(companyName);
        requestBody.setSeller_name(sellerName);
        requestBody.setEmail(email);
        requestBody.setPhone_number(phoneNum);
        requestBody.setAddress(address);

        Response response = RestAssured.given().auth().oauth2(token).
                contentType(ContentType.JSON).body(requestBody).
                post("https://backend.cashwise.us/api/myaccount/sellers");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(200, response.statusCode());
        int id = response.jsonPath().get("seller_id");

        String url = "https://backend.cashwise.us/api/myaccount/sellers/" + id;
        Response response1 = RestAssured.given().auth().oauth2(token).get(url);
        Assert.assertEquals(200, response1.statusCode());

        System.out.println("Get one Seller");
        System.out.println(response1.asPrettyString());




    }

}
