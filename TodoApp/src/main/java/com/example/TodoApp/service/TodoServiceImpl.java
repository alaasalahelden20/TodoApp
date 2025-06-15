package com.example.TodoApp.service;

import com.example.TodoApp.dto.TodoDto;
import com.example.TodoApp.dto.UserDto;
import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.entity.User;
import com.example.TodoApp.mapper.TodoMapper;
import com.example.TodoApp.repositories.TodoRepository;
import com.example.TodoApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@AllArgsConstructor
@Service

public class TodoServiceImpl implements TodoService{
    private TodoRepository todoRepository;
    @Autowired
    TodoMapper todoMapper;
    @Autowired
    UserRepository userRepository;
    @Override
    public TodoDto createDto(TodoDto todoDto,String username) {
        User user=userRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Todo todo= todoMapper.toTodoEntity(todoDto);
        todo.setUser(user);
        Todo SavedTodo=todoRepository.save(todo);
        return todoMapper.toTodoDto(SavedTodo);
    }

    @Override
    public TodoDto getTodoById(long Id,String username){
        Todo todo=todoRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        if (!todo.getUser().getUsername().equals(username)) {
            throw new AccessDeniedException("You do not have access to this Todo");
        }
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
