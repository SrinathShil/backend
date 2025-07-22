package com.firefi.backend.dto;

import lombok.Data;

@Data
public class CreateAccountRequest {
    private String username;
    private String password;
    private String email;
}