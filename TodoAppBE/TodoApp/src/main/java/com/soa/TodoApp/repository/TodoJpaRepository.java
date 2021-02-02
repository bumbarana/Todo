package com.soa.TodoApp.repository;

import com.soa.TodoApp.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoEntity,Long> {
    List<TodoEntity> findAllByUserId(Long id);
}
