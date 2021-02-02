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
public class TeacherMapperImpl implements TeacherMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public TeacherDto Entity2Dto(TeacherEntity dao) {
        if ( dao == null ) {
            return null;
        }

        TeacherDto teacherDto = new TeacherDto();

        if ( dao.getTeacherId() != null ) {
            teacherDto.setTeacherId( String.valueOf( dao.getTeacherId() ) );
        }
        teacherDto.setFirstName( dao.getFirstName() );
        teacherDto.setLastName( dao.getLastName() );
        teacherDto.setEmail( dao.getEmail() );
        teacherDto.setPhoto( entityToDtoPhoto( dao.getPhoto() ) );
        teacherDto.setPassword( dao.getPassword() );
        teacherDto.setAddress( addressMapper.Entity2Dto( dao.getAddress() ) );
        teacherDto.setJob( dao.getJob() );
        teacherDto.setCv( entityToDtoCv( dao.getCv() ) );
        teacherDto.setInterestList( interestEntityListToInterestDtoList( dao.getInterestList() ) );
        teacherDto.setTitleList( titleEntityListToTitleDtoList( dao.getTitleList() ) );

        return teacherDto;
    }

    @Override
    public TeacherEntity Dto2Entity(TeacherDto dto) {
        if ( dto == null ) {
            return null;
        }

        TeacherEntity teacherEntity = new TeacherEntity();

        if ( dto.getTeacherId() != null ) {
            teacherEntity.setTeacherId( Long.parseLong( dto.getTeacherId() ) );
        }
        teacherEntity.setFirstName( dto.getFirstName() );
        teacherEntity.setLastName( dto.getLastName() );
        teacherEntity.setEmail( dto.getEmail() );
        teacherEntity.setPhoto( dtoToEntityPhoto( dto.getPhoto() ) );
        teacherEntity.setPassword( dto.getPassword() );
        teacherEntity.setAddress( addressMapper.Dto2Entity( dto.getAddress() ) );
        teacherEntity.setCv( dtoToEntityCv( dto.getCv() ) );
        teacherEntity.setJob( dto.getJob() );
        teacherEntity.setTitleList( titleDtoListToTitleEntityList( dto.getTitleList() ) );
        teacherEntity.setInterestList( interestDtoListToInterestEntityList( dto.getInterestList() ) );

        return teacherEntity;
    }

    @Override
    public List<TeacherDto> EntityList2DtoList(List<TeacherEntity> daos) {
        if ( daos == null ) {
            return null;
        }

        List<TeacherDto> list = new ArrayList<TeacherDto>( daos.size() );
        for ( TeacherEntity teacherEntity : daos ) {
            list.add( Entity2Dto( teacherEntity ) );
        }

        return list;
    }

    @Override
    public List<TeacherEntity> DtoListToEntityList(List<TeacherDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<TeacherEntity> list = new ArrayList<TeacherEntity>( dtos.size() );
        for ( TeacherDto teacherDto : dtos ) {
            list.add( Dto2Entity( teacherDto ) );
        }

        return list;
    }

    protected InterestDto interestEntityToInterestDto(InterestEntity interestEntity) {
        if ( interestEntity == null ) {
            return null;
        }

        InterestDto interestDto = new InterestDto();

        if ( interestEntity.getInterestId() != null ) {
            interestDto.setInterestId( String.valueOf( interestEntity.getInterestId() ) );
        }
        interestDto.setName( interestEntity.getName() );

        return interestDto;
    }

    protected List<InterestDto> interestEntityListToInterestDtoList(List<InterestEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<InterestDto> list1 = new ArrayList<InterestDto>( list.size() );
        for ( InterestEntity interestEntity : list ) {
            list1.add( interestEntityToInterestDto( interestEntity ) );
        }

        return list1;
    }

    protected TitleDto titleEntityToTitleDto(TitleEntity titleEntity) {
        if ( titleEntity == null ) {
            return null;
        }

        TitleDto titleDto = new TitleDto();

        if ( titleEntity.getTitleId() != null ) {
            titleDto.setTitleId( String.valueOf( titleEntity.getTitleId() ) );
        }
        titleDto.setName( titleEntity.getName() );

        return titleDto;
    }

    protected List<TitleDto> titleEntityListToTitleDtoList(List<TitleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<TitleDto> list1 = new ArrayList<TitleDto>( list.size() );
        for ( TitleEntity titleEntity : list ) {
            list1.add( titleEntityToTitleDto( titleEntity ) );
        }

        return list1;
    }

    protected TitleEntity titleDtoToTitleEntity(TitleDto titleDto) {
        if ( titleDto == null ) {
            return null;
        }

        TitleEntity titleEntity = new TitleEntity();

        if ( titleDto.getTitleId() != null ) {
            titleEntity.setTitleId( Long.parseLong( titleDto.getTitleId() ) );
        }
        titleEntity.setName( titleDto.getName() );

        return titleEntity;
    }

    protected List<TitleEntity> titleDtoListToTitleEntityList(List<TitleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<TitleEntity> list1 = new ArrayList<TitleEntity>( list.size() );
        for ( TitleDto titleDto : list ) {
            list1.add( titleDtoToTitleEntity( titleDto ) );
        }

        return list1;
    }

    protected InterestEntity interestDtoToInterestEntity(InterestDto interestDto) {
        if ( interestDto == null ) {
            return null;
        }

        InterestEntity interestEntity = new InterestEntity();

        if ( interestDto.getInterestId() != null ) {
            interestEntity.setInterestId( Long.parseLong( interestDto.getInterestId() ) );
        }
        interestEntity.setName( interestDto.getName() );

        return interestEntity;
    }

    protected List<InterestEntity> interestDtoListToInterestEntityList(List<InterestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<InterestEntity> list1 = new ArrayList<InterestEntity>( list.size() );
        for ( InterestDto interestDto : list ) {
            list1.add( interestDtoToInterestEntity( interestDto ) );
        }

        return list1;
    }
}
