package com.example.TodoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor @NoArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
    private Long Id;
}
