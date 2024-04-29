package org.example.practisequerydslcrud.dto.request;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private String username;
    public String email;
    private String role;
}
