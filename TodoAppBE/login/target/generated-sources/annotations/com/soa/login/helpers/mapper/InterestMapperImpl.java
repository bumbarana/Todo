package com.soa.login.helpers.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-28T00:10:35+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class InterestMapperImpl implements InterestMapper {

    @Override
    public InterestDto Entity2Dto(InterestEntity dao) {
        if ( dao == null ) {
            return null;
        }

        InterestDto interestDto = new InterestDto();

        if ( dao.getInterestId() != null ) {
            interestDto.setInterestId( String.valueOf( dao.getInterestId() ) );
        }
        interestDto.setName( dao.getName() );

        return interestDto;
    }

    @Override
    public InterestEntity Dto2Entity(InterestDto dto) {
        if ( dto == null ) {
            return null;
        }

        InterestEntity interestEntity = new InterestEntity();

        if ( dto.getInterestId() != null ) {
            interestEntity.setInterestId( Long.parseLong( dto.getInterestId() ) );
        }
        interestEntity.setName( dto.getName() );

        return interestEntity;
    }

    @Override
    public List<InterestDto> EntityList2DtoList(List<InterestEntity> daos) {
        if ( daos == null ) {
            return null;
        }

        List<InterestDto> list = new ArrayList<InterestDto>( daos.size() );
        for ( InterestEntity interestEntity : daos ) {
            list.add( Entity2Dto( interestEntity ) );
        }

        return list;
    }

    @Override
    public List<InterestEntity> DtoListToEntityList(List<InterestDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<InterestEntity> list = new ArrayList<InterestEntity>( dtos.size() );
        for ( InterestDto interestDto : dtos ) {
            list.add( Dto2Entity( interestDto ) );
        }

        return list;
    }
}
