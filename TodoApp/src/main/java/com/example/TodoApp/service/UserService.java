package com.example.TodoApp.service;

import com.example.TodoApp.dto.ResponseDto;
import com.example.TodoApp.dto.TodoDto;
import com.example.TodoApp.dto.RegistrationDto;

import java.util.List;

public interface UserService {
    public ResponseDto register(RegistrationDto registrationDto);
    public List<RegistrationDto> getAllUsers();
    public boolean existByUserNameOrEmail(String Username, String Email);
    public List<TodoDto> getUserTodos(String username);
    ResponseDto updateDto(Long Id, RegistrationDto registrationDto);

    public void delUserById(long Id);

}
