package com.example.TodoApp.mapper;

import com.example.TodoApp.dto.TodoDto;
import com.example.TodoApp.dto.UserDto;
import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    ModelMapper modelMapper;

    public User toUserEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

    public UserDto toUserDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> toUserDtoList(List<User> users){
        return users.stream().map
                (user ->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }


}
