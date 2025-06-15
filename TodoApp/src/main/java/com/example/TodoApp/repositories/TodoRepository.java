package com.example.TodoApp.repositories;

import com.example.TodoApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByUser_Username(String username);

}
