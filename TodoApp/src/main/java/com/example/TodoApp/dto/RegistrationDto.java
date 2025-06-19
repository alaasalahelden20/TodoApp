package com.example.TodoApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RegistrationDto {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")

    private String username;
    @Email(message = "Email is not valid")
    private  String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
            ,message = "the password should be : At least one lowercase letter, At least one uppercase letter, At least one digit, At least one special character from the set @$!%*?&, and A minimum length of 8 characters. ")
    private String password;


}
