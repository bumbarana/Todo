package com.soa.TodoApp.repository;

import com.soa.TodoApp.dto.TodoDto;
import com.soa.TodoApp.entity.TodoEntity;
import com.soa.TodoApp.helpers.mapper.TodoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class TodoRepository {
    private TodoJpaRepository todoJpaRepository;
    private TodoMapper todoMapper;

    @Autowired
    public TodoRepository(final TodoJpaRepository todoJpaRepository, final TodoMapper todoMapper) {
        this.todoJpaRepository = todoJpaRepository;
        this.todoMapper = todoMapper;

    }

    public TodoDto save(final TodoDto todoToSave){

        TodoEntity todoEntity = todoJpaRepository.save(todoMapper.Dto2Entity(todoToSave));
        log.info(todoEntity + " a");
        return todoMapper.Entity2Dto(todoEntity);
    }


    public List<TodoDto> findAllTodosByUserId(Long id){
        List<TodoEntity> allTodos = todoJpaRepository.findAllByUserId(id);
        return todoMapper.EntityList2DtoList(allTodos);
    }

    public void delete(final String todoId){
        TodoEntity entityToDelete = todoJpaRepository.getOne(Long.valueOf(todoId));
        todoJpaRepository.delete(entityToDelete);
        return;
    }

    public List<TodoDto> findAll() {
        List<TodoEntity> allTodos = todoJpaRepository.findAll();
        return todoMapper.EntityList2DtoList(allTodos);
    }
}
