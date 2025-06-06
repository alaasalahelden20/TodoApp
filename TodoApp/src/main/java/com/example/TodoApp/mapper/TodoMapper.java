package com.example.TodoApp.mapper;

import com.example.TodoApp.dto.TodoDto;
import com.example.TodoApp.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapper {
    @Autowired
    private ModelMapper modelMapper;



    public Todo toTodoEntity(TodoDto todoDto){

        return modelMapper.map(todoDto,Todo.class);
    }

    public TodoDto toTodoDto (Todo todo){
        return modelMapper.map(todo,TodoDto.class);
    }

    public List<TodoDto> toDtoList(List<Todo> todos){
        return todos.stream().map
                (todo ->modelMapper.map(todo,TodoDto.class)).collect(Collectors.toList());


    }


}
