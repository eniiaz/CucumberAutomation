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

}
