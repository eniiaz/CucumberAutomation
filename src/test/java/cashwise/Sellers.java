package cashwise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.Test;
import utilities.APIRunner;

public class Sellers {

    @Test
    public void createSeller(){
        String path = "/api/myaccount/sellers";
        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name("Amazon.com");
        requestBody.setSeller_name("Epson Brother");
        requestBody.setEmail("epson@gmail.com");
        requestBody.setPhone_number("982497239");
        requestBody.setAddress("Online store");

        APIRunner.runPOST(path, requestBody);
    }

    @Test
    public void create10Sellers(){
        String path = "/api/myaccount/sellers";
        Faker faker = new Faker();
        RequestBody requestBody = new RequestBody();
        for (int i = 0; i < 10; i++){
            requestBody.setCompany_name(faker.company().name());
            requestBody.setSeller_name(faker.name().fullName());
            requestBody.setPhone_number(faker.phoneNumber().phoneNumber());
            requestBody.setEmail(faker.internet().emailAddress());
            requestBody.setAddress(faker.address().fullAddress());

            APIRunner.runPOST(path, requestBody);

        }
    }

    @Test
    public void createBankAccount(){
        String path = "/api/myaccount/bankaccount";
        RequestBody requestBody = new RequestBody();
        requestBody.setType_of_pay("BANK");
        requestBody.setBank_account_name("Bank of America Credit");
        requestBody.setDescription("BoA credit account");
        requestBody.setBalance(4500);

        APIRunner.runPOST(path, requestBody);
        System.out.println(APIRunner.getCustomResponse().getBank_account_name());
    }

}
