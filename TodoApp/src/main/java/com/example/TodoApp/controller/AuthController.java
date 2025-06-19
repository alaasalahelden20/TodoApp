package com.example.TodoApp.controller;

import com.example.TodoApp.dto.LoginRequest;
import com.example.TodoApp.dto.RegistrationDto;
import com.example.TodoApp.dto.ResponseDto;
import com.example.TodoApp.security.jwt.JwtUtil;
import com.example.TodoApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid; // Not javax.validation

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping()
    public ResponseEntity<?> Register(@Valid @RequestBody  RegistrationDto registrationDto){

        ResponseDto user=userService.register(registrationDto);
        System.out.println(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);


    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
            try {
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
                );
                UserDetails userDetails = (UserDetails) auth.getPrincipal();

                // If successful, you can generate JWT token here or return success
                return ResponseEntity.ok().body(jwtUtil.generateToken(userDetails.getUsername(),request.getId()));
            } catch (AuthenticationException ex) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        }











}
