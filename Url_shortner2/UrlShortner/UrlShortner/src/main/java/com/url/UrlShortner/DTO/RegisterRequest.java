package com.url.UrlShortner.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequest {

    private String username;
    private String email;
    private String roles;
    private String password;
}
