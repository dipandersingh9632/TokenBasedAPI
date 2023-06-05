package com.cybersecure.tokenbasedapi.dtos;

import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String username;
    private String password;
}
