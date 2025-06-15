package com.example.TodoApp.service;

import com.example.TodoApp.dto.UserDto;
import com.example.TodoApp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    public UserDto register(UserDto userDto);
    public List<UserDto> getAllUsers();
    public Boolean existByUserNameOrEmail(String Username, String Email);
}
