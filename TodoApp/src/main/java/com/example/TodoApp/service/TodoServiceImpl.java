package com.example.TodoApp.service;

import com.example.TodoApp.dto.TodoDto;
import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.mapper.TodoMapper;
import com.example.TodoApp.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@AllArgsConstructor
@Service

public class TodoServiceImpl implements TodoService{
    private TodoRepository todoRepository;
    @Autowired
    TodoMapper todoMapper;
    @Override
    public TodoDto createDto(TodoDto todoDto) {
        Todo todo= todoMapper.toTodoEntity(todoDto);
        Todo SavedTodo=todoRepository.save(todo);
        return todoMapper.toTodoDto(SavedTodo);
    }
    @Override
    public TodoDto getTodoById(long Id){
        Todo todo=todoRepository.getReferenceById(Id);
        return todoMapper.toTodoDto(todo);
    }
    @Override
    public List<TodoDto> getTodos(){
        List<Todo> todosDto=todoRepository.findAll();
        return todoMapper.toDtoList(todosDto);


    }

    @Override
    public TodoDto updateDto (Long Id,TodoDto todoDto){
        Todo todo=todoRepository.getReferenceById(Id);
        todo.setName(todoDto.getName());
        todo.setIsChecked(todoDto.getIsChecked());
        todoRepository.save(todo);
        return todoMapper.toTodoDto(todo);


    }

    @Override
    public void delTodoById(Long Id){
        Todo todo=todoRepository.getReferenceById(Id);
         todoRepository.deleteById(todo.getId());

    }
}
