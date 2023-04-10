package models;

import lombok.Data;

import java.util.List;

@Data
public class MyResponse {

    private String jwt_token;
    private String message;
    private List<String> authorities;
    private String category_title;
    private String category_description;
    private boolean flag;


}
