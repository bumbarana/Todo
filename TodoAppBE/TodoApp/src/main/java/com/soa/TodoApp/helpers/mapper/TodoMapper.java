package com.soa.TodoApp.helpers.mapper;

import com.soa.TodoApp.dto.TodoDto;
import com.soa.TodoApp.entity.TodoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoDto Entity2Dto(TodoEntity todoEntity);

    TodoEntity Dto2Entity(TodoDto todoDto);

    List<TodoEntity> DtoList2EntityList(List<TodoDto> dtos);
    List<TodoDto> EntityList2DtoList(List<TodoEntity> entities);
}
