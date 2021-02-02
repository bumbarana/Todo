package com.soa.TodoApp.helpers.mapper;

import com.soa.TodoApp.dto.TodoDto;
import com.soa.TodoApp.entity.TodoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-01T21:58:47+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public TodoDto Entity2Dto(TodoEntity todoEntity) {
        if ( todoEntity == null ) {
            return null;
        }

        TodoDto todoDto = new TodoDto();

        if ( todoEntity.getTodoId() != null ) {
            todoDto.setTodoId( String.valueOf( todoEntity.getTodoId() ) );
        }
        todoDto.setSubject( todoEntity.getSubject() );
        todoDto.setDescription( todoEntity.getDescription() );
        if ( todoEntity.getPriority() != null ) {
            todoDto.setPriority( String.valueOf( todoEntity.getPriority() ) );
        }
        if ( todoEntity.getUserId() != null ) {
            todoDto.setUserId( String.valueOf( todoEntity.getUserId() ) );
        }

        return todoDto;
    }

    @Override
    public TodoEntity Dto2Entity(TodoDto todoDto) {
        if ( todoDto == null ) {
            return null;
        }

        TodoEntity todoEntity = new TodoEntity();

        if ( todoDto.getTodoId() != null ) {
            todoEntity.setTodoId( Long.parseLong( todoDto.getTodoId() ) );
        }
        todoEntity.setSubject( todoDto.getSubject() );
        todoEntity.setDescription( todoDto.getDescription() );
        if ( todoDto.getPriority() != null ) {
            todoEntity.setPriority( Long.parseLong( todoDto.getPriority() ) );
        }
        if ( todoDto.getUserId() != null ) {
            todoEntity.setUserId( Long.parseLong( todoDto.getUserId() ) );
        }

        return todoEntity;
    }

    @Override
    public List<TodoEntity> DtoList2EntityList(List<TodoDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<TodoEntity> list = new ArrayList<TodoEntity>( dtos.size() );
        for ( TodoDto todoDto : dtos ) {
            list.add( Dto2Entity( todoDto ) );
        }

        return list;
    }

    @Override
    public List<TodoDto> EntityList2DtoList(List<TodoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TodoDto> list = new ArrayList<TodoDto>( entities.size() );
        for ( TodoEntity todoEntity : entities ) {
            list.add( Entity2Dto( todoEntity ) );
        }

        return list;
    }
}
