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
public class TitleMapperImpl implements TitleMapper {

    @Override
    public TitleDto Entity2Dto(TitleEntity dao) {
        if ( dao == null ) {
            return null;
        }

        TitleDto titleDto = new TitleDto();

        if ( dao.getTitleId() != null ) {
            titleDto.setTitleId( String.valueOf( dao.getTitleId() ) );
        }
        titleDto.setName( dao.getName() );

        return titleDto;
    }

    @Override
    public TitleEntity Dto2Entity(TitleDto dto) {
        if ( dto == null ) {
            return null;
        }

        TitleEntity titleEntity = new TitleEntity();

        if ( dto.getTitleId() != null ) {
            titleEntity.setTitleId( Long.parseLong( dto.getTitleId() ) );
        }
        titleEntity.setName( dto.getName() );

        return titleEntity;
    }

    @Override
    public List<TitleDto> EntityList2DtoList(List<TitleEntity> daos) {
        if ( daos == null ) {
            return null;
        }

        List<TitleDto> list = new ArrayList<TitleDto>( daos.size() );
        for ( TitleEntity titleEntity : daos ) {
            list.add( Entity2Dto( titleEntity ) );
        }

        return list;
    }

    @Override
    public List<TitleEntity> DtoListToEntityList(List<TitleDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<TitleEntity> list = new ArrayList<TitleEntity>( dtos.size() );
        for ( TitleDto titleDto : dtos ) {
            list.add( Dto2Entity( titleDto ) );
        }

        return list;
    }
}
