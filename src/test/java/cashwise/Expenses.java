package cashwise;

import org.junit.Assert;
import org.junit.Test;
import utilities.APIRunner;

public class Expenses {

    @Test
    public void seller(){
        String path = "/api/myaccount/sellers/359";
        APIRunner.runGET(path);

        Assert.assertNotNull(APIRunner.getCustomResponse().getSeller_name());
        Assert.assertNotNull(APIRunner.getCustomResponse().getCompany_name());
        Assert.assertNotNull(APIRunner.getCustomResponse().getEmail());
        Assert.assertNotNull(APIRunner.getCustomResponse().getPhone_number());

        Assert.assertFalse(APIRunner.getCustomResponse().getSeller_name().trim().isEmpty());
        Assert.assertFalse(APIRunner.getCustomResponse().getCompany_name().trim().isEmpty());
        Assert.assertFalse(APIRunner.getCustomResponse().getEmail().trim().isEmpty());
        Assert.assertFalse(APIRunner.getCustomResponse().getPhone_number().trim().isEmpty());

        Assert.assertTrue(APIRunner.getCustomResponse().getEmail().
                contains("@") && APIRunner.getCustomResponse().getEmail().contains("."));

        String phoneNumber = APIRunner.getCustomResponse().getPhone_number();
        phoneNumber = phoneNumber.replace("+", "");
        phoneNumber = phoneNumber.replace("-", "");
        phoneNumber = phoneNumber.replace(" ", "");

        Assert.assertTrue(phoneNumber.length() == 10 || phoneNumber.length() == 11);

    }


    @Test
    public void singleBankAccount(){
        String path = "/api/myaccount/bankaccount/439";
        APIRunner.runGET(path);

        Assert.assertEquals(200, APIRunner.getCustomResponse().getStatusCode());
    }
    
    @Test
    public void verifySellers(){
        String path = "/api/myaccount/sellers/all";
        APIRunner.runGetList(path);
        System.out.println(APIRunner.getResponseList().length);
        for (int i = 0; i < APIRunner.getResponseList().length; i++){
            Assert.assertNotNull(APIRunner.getResponseList()[i].getSeller_name());
            Assert.assertNotNull(APIRunner.getResponseList()[i].getCompany_name());
        }
    }

}
