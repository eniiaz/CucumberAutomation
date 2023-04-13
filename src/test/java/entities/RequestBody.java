package entities;

import lombok.Data;

@Data
public class RequestBody {

    private String password;
    private String email;
    private String company_name;
    private String seller_name;
    private String phone_number;
    private String address;
    private String type_of_pay;
    private String bank_account_name;
    private String description;
    private int balance;

}
