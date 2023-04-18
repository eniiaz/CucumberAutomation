package cashwise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.Test;
import utilities.APIRunner;

public class Tags {

    @Test
    public void createTag(){
        String path = "/api/myaccount/tags";
        RequestBody requestBody = new RequestBody();
        Faker faker = new Faker();

        for (int i = 0; i < 7; i++){
            requestBody.setName_tag(faker.pokemon().name());
            requestBody.setDescription(faker.funnyName().name());
            APIRunner.runPOST(path, requestBody);
        }
    }



}
