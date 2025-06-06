package com.example.TodoApp.controller;


import com.example.TodoApp.dto.TodoDto;
import com.example.TodoApp.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.status;

@AllArgsConstructor
@RequestMapping("/api/todo")
@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping()
    public ResponseEntity<TodoDto> AddTodo(@RequestBody @Valid TodoDto todoDto){
        TodoDto savedTodo=todoService.createDto(todoDto);
        return new ResponseEntity<>(savedTodo,HttpStatus.CREATED);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<TodoDto> GetTodoById (@PathVariable long Id){
        TodoDto todo=todoService.getTodoById(Id);
        return new ResponseEntity<>(todo,HttpStatus.ACCEPTED);
    }
    @GetMapping()
    public ResponseEntity< List<TodoDto>> getTodos(){
        List<TodoDto> todos=todoService.getTodos();
        return new ResponseEntity<>(todos,HttpStatus.ACCEPTED);



    }
    @PutMapping("/{Id}")
    public ResponseEntity<TodoDto> updateDto(@PathVariable Long Id,@RequestBody TodoDto todoDto){
        TodoDto updateDto=todoService.updateDto(Id,todoDto);
        return new ResponseEntity<>(updateDto,HttpStatus.CREATED);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> delTodo(@PathVariable Long Id){
        todoService.delTodoById(Id);
        return ResponseEntity.ok("Todo deleted succesfully");
    }

}
