package com.example.Reservas.Auth.dtos;

import lombok.Data;

@Data
public class AuthLoginRequest {
    private String email;
    private String password;
}
