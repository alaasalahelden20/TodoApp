package com.example.TodoApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    @Column(unique = true)
    private String username;
    @Email
    private  String email;
    private String password;

}
