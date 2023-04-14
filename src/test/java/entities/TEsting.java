package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;

public class TEsting {

    @Test
    public void test() throws JsonProcessingException {
        String path = "/api/myaccount/bankaccount";
        APIRunner.runGetList(path);
        for (int i = 0; i < APIRunner.getResponseList().length; i++){
            System.out.println(APIRunner.getResponseList()[i].getBalance());
        }

    }

    @Test
    public void create(){
        String path = "/api/myaccount/sellers";
        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name("Credit Ninja");
        requestBody.setSeller_name("Joe");
        requestBody.setBalance(500);
        requestBody.setEmail("joe@rogan.com");

        APIRunner.runPOST(path, requestBody);
    }

    @Test
    public void createProduct(){
        String path = "/api/myaccount/products";
        RequestBody requestBody = new RequestBody();
        requestBody.setProduct_title("Outsource");
        requestBody.setProduct_price(10000);
        requestBody.setService_type_id(1);
        requestBody.setCategory_id(1);
        requestBody.setProduct_description("We do outsourcing");

        APIRunner.runPOST(path, requestBody);
    }

}
