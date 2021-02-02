package com.soa.login.helpers.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-28T00:10:35+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public StudentDto Entity2Dto(StudentEntity dao) {
        if ( dao == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        if ( dao.getStudentId() != null ) {
            studentDto.setStudentId( String.valueOf( dao.getStudentId() ) );
        }
        studentDto.setFirstName( dao.getFirstName() );
        studentDto.setLastName( dao.getLastName() );
        studentDto.setEmail( dao.getEmail() );
        studentDto.setPhoto( entityToDtoPhoto( dao.getPhoto() ) );
        studentDto.setPhone( dao.getPhone() );
        studentDto.setPassword( dao.getPassword() );
        studentDto.setAddress( addressMapper.Entity2Dto( dao.getAddress() ) );

        return studentDto;
    }

    @Override
    public StudentEntity Dto2Entity(StudentDto dto) {
        if ( dto == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        if ( dto.getStudentId() != null ) {
            studentEntity.setStudentId( Long.parseLong( dto.getStudentId() ) );
        }
        studentEntity.setFirstName( dto.getFirstName() );
        studentEntity.setLastName( dto.getLastName() );
        studentEntity.setEmail( dto.getEmail() );
        studentEntity.setPhoto( dtoToEntityPhoto( dto.getPhoto() ) );
        studentEntity.setPhone( dto.getPhone() );
        studentEntity.setPassword( dto.getPassword() );
        studentEntity.setAddress( addressMapper.Dto2Entity( dto.getAddress() ) );

        return studentEntity;
    }

    @Override
    public List<StudentDto> EntityList2DtoList(List<StudentEntity> daos) {
        if ( daos == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( daos.size() );
        for ( StudentEntity studentEntity : daos ) {
            list.add( Entity2Dto( studentEntity ) );
        }

        return list;
    }
}
