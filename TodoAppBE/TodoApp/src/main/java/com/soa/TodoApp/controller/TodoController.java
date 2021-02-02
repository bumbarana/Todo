package com.soa.TodoApp.controller;

import com.soa.TodoApp.dto.TodoDto;
import com.soa.TodoApp.helpers.constants.EndpointConstants;
import com.soa.TodoApp.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class TodoController {
    private TodoService todoHandler;

    @Autowired
    public TodoController(final TodoService todoHandler) {
        this.todoHandler = todoHandler;
    }

    @PostMapping(EndpointConstants.ADD_TODO)
    @PreAuthorize("hasAuthority('USER')")
    public void saveTodo(@RequestBody TodoDto todoDto) {
        log.info("*******" + todoDto);
        todoHandler.saveTodo(todoDto);

    }

    @GetMapping(EndpointConstants.GET_TODOS + "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<TodoDto>> getAllTodosByUserId(@PathVariable("id") Long id) {
        List<TodoDto> todos = todoHandler.getTodosByUserId(id);
        log.info("todos-----");
        log.info("All todos: " + todos.size());
        return new ResponseEntity<>(todos, HttpStatus.OK);

    }

    @PostMapping(EndpointConstants.REMOVE_TODO + "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public void deleteTodo(@PathVariable("id") String todoId){

        try {
            this.todoHandler.removeTodo(todoId);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping(EndpointConstants.GET_TODOS)
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = todoHandler.getTodos();
        log.info("todos-----");
        log.info("All todos: " + todos.size());
        return new ResponseEntity<>(todos, HttpStatus.OK);

    }
}
