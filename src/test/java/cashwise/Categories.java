package cashwise;

import entities.RequestBody;
import org.junit.Test;
import utilities.APIRunner;

public class Categories {

    @Test
    public void updateDescriptions(){

        String getCategoryPath = "/api/myaccount/categories/income";
        APIRunner.runGetList(getCategoryPath);

        for (int i = 0; i < APIRunner.getResponseList().length; i++){
            String updatePath = "/api/myaccount/categories/" + APIRunner.getResponseList()[i].getCategory_id();
            RequestBody requestBody = new RequestBody();
            requestBody.setCategory_title(APIRunner.getResponseList()[i].getCategory_title());
            requestBody.setCategory_description("For income purpose");
            requestBody.setFlag(true);
            APIRunner.runPUT(updatePath, requestBody);
        }
    }
}
