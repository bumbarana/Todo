package com.soa.login.helpers.mapper;

import com.soa.login.dto.UserDto;
import com.soa.login.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-01T22:03:15+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto Entity2Dto(UserEntity dao) {
        if ( dao == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( dao.getUserId() != null ) {
            userDto.setUserId( String.valueOf( dao.getUserId() ) );
        }
        userDto.setFirstName( dao.getFirstName() );
        userDto.setLastName( dao.getLastName() );
        userDto.setEmail( dao.getEmail() );
        userDto.setPassword( dao.getPassword() );

        return userDto;
    }

    @Override
    public UserEntity Dto2Entity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        if ( dto.getUserId() != null ) {
            userEntity.setUserId( Long.parseLong( dto.getUserId() ) );
        }
        userEntity.setFirstName( dto.getFirstName() );
        userEntity.setLastName( dto.getLastName() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setPassword( dto.getPassword() );

        return userEntity;
    }

    @Override
    public List<UserDto> EntityList2DtoList(List<UserEntity> daos) {
        if ( daos == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( daos.size() );
        for ( UserEntity userEntity : daos ) {
            list.add( Entity2Dto( userEntity ) );
        }

        return list;
    }
}
