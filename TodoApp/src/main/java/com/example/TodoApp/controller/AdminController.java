package com.example.TodoApp.controller;

import com.example.TodoApp.dto.RegistrationDto;
import com.example.TodoApp.dto.ResponseDto;
import com.example.TodoApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<RegistrationDto>> getAllUsers() {
        List<RegistrationDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<ResponseDto> updateDto(@PathVariable Long Id, @RequestBody RegistrationDto registrationDto){
        ResponseDto updateDto=userService.updateDto(Id, registrationDto);
        return new ResponseEntity<>(updateDto,HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> delTodo(@PathVariable Long Id){
        userService.delUserById(Id);
        return ResponseEntity.ok("User deleted succesfully");
    }

    }
