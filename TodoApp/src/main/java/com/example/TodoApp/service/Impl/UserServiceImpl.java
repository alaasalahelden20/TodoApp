package com.example.TodoApp.service.Impl;

import com.example.TodoApp.Exception.UserAlreadyExistsException;
import com.example.TodoApp.dto.ResponseDto;
import com.example.TodoApp.dto.TodoDto;
import com.example.TodoApp.dto.RegistrationDto;
import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.entity.User;
import com.example.TodoApp.mapper.TodoMapper;
import com.example.TodoApp.mapper.UserMapper;
import com.example.TodoApp.repositories.UserRepository;
import com.example.TodoApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;
@Autowired
private UserMapper userMapper;
@Autowired
private TodoMapper todoMapper;
@Autowired
private BCryptPasswordEncoder passwordEncoder;




    @Override
    public ResponseDto register(RegistrationDto registrationDto) {
        System.out.println(userRepository.findByUsername(registrationDto.getUsername()).isPresent());

        // Check if user already exists - throw exception if found
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User with this username or email already exists");
        }

        // Encode password
        registrationDto.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        // Convert to entity and save
        User user = userMapper.toUserEntity(registrationDto);
        System.out.println(user);

        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public List<RegistrationDto> getAllUsers() {
        List<User> users=userRepository.findAll() ;

        return userMapper.toUserDtoList(users);
    }

    @Override
    public boolean existByUserNameOrEmail(String Username,String Email) {
        return userRepository.existsByUsername(Username) || userRepository.existsByEmail(Email);

    }

    @Override
    public List<TodoDto> getUserTodos(String username) {
        User user=userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
        List<Todo> userTodos=user.getTodos();
        return todoMapper.toDtoList(userTodos);

    }

    @Override
    public ResponseDto updateDto (Long Id, RegistrationDto userTodo){
        User user=userRepository.getReferenceById(Id);
        user.setUsername(userTodo.getUsername());
        user.setEmail(userTodo.getEmail());
        userRepository.save(user);
        return userMapper.toUserDto(user);


    }

    @Override
    public void delUserById(long Id) {
        userRepository.deleteById(Id);
    }


}
