package com.example.TodoApp.dto;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
public class TodoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    @Column(unique = true)
    private String name;
    private Boolean isChecked;

}
