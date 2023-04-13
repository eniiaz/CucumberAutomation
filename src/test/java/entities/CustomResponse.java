package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomResponse {

    private String jwt_token;
    private String message;
    private String company_name;
    private String seller_name;
    private boolean income;
    private String bank_account_name;
    private String id;
    private int balance;
    private String phone_number;
    private String email;
    private String jsonString;
    private int statusCode;

}
