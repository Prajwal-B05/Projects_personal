package com.url.UrlShortner.Models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;
    private String password;
    private String role;

}
