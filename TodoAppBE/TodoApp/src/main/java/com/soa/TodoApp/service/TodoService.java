package com.soa.TodoApp.service;

import com.soa.TodoApp.dto.TodoDto;
import com.soa.TodoApp.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;


    public List<TodoDto> getTodosByUserId(Long id) {
        List<TodoDto> todos = todoRepository.findAllTodosByUserId(id);
        return todos;
    }

    public List<TodoDto> getTodos() {
        List<TodoDto> todos = todoRepository.findAll();
        return todos;
    }

    public TodoDto saveTodo(TodoDto todo) {
        return todoRepository.save(todo);
    }

    public void removeTodo(String id) {
        todoRepository.delete(id);
    }
}
