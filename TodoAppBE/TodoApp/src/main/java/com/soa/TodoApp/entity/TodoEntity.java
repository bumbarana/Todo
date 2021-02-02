package com.soa.TodoApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="TODOS", schema = "todo")
@Data
@SequenceGenerator(name="TodoSeq", sequenceName = "SEQ_TODOS", allocationSize = 1)
public class TodoEntity {
    public static final String TODO_ID = "TODO_ID";
    public static final String SUBJECT = "SUBJECT";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String PRIORITY = "PRIORITY";
    public static final String USER_ID = "USER_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TodoSeq")
    @Column(name = TODO_ID)
    private Long todoId;

    @Column(name = SUBJECT)
    private String subject;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = PRIORITY)
    private Long priority;

    @Column(name = USER_ID)
    private Long userId;

}
