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

}
