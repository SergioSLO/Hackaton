package com.example.Reservas.Auth.dtos;

import lombok.Data;

@Data
public class AuthRegisterRequest {
    private String name;
    private String email;
    private String password;
    public Boolean isAdmin;
}
