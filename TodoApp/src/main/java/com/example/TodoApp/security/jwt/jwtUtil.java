package com.example.TodoApp.security.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class jwtUtil {
    @Value("${jwt.secert}")
    private String jwtSecret;
    @Value("${jwt.token.lifespan}")
    private Long lifespan;

     private SecretKey getSigningKey(){
         return Keys.hmacShaKeyFor(jwtSecret.getBytes());
     }
}
