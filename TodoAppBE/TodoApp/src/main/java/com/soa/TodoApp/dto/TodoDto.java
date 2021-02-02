package com.soa.TodoApp.dto;

import lombok.Data;

@Data
public class TodoDto {
    private String todoId;
    private String subject;
    private String description;
    private String priority;
    private String userId;
}
