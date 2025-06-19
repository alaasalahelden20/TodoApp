package com.example.TodoApp.mapper;

import com.example.TodoApp.dto.RegistrationDto;
import com.example.TodoApp.dto.ResponseDto;
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

    public User toUserEntity(RegistrationDto registrationDto){
        return modelMapper.map(registrationDto, User.class);
    }

    public ResponseDto toUserDto(User user){
        return modelMapper.map(user, ResponseDto.class);
    }

    public List<RegistrationDto> toUserDtoList(List<User> users){
        return users.stream().map
                (user ->modelMapper.map(user, RegistrationDto.class)).collect(Collectors.toList());
    }


}
