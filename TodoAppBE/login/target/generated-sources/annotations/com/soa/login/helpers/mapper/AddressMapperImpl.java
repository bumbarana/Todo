package com.soa.login.helpers.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-28T00:10:34+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto Entity2Dto(AddressEntity dao) {
        if ( dao == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        if ( dao.getAddressId() != null ) {
            addressDto.setAddressId( String.valueOf( dao.getAddressId() ) );
        }
        addressDto.setCountry( dao.getCountry() );
        addressDto.setCity( dao.getCity() );
        addressDto.setStreet( dao.getStreet() );

        return addressDto;
    }

    @Override
    public AddressEntity Dto2Entity(AddressDto dto) {
        if ( dto == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        if ( dto.getAddressId() != null ) {
            addressEntity.setAddressId( Long.parseLong( dto.getAddressId() ) );
        }
        addressEntity.setCountry( dto.getCountry() );
        addressEntity.setCity( dto.getCity() );
        addressEntity.setStreet( dto.getStreet() );

        return addressEntity;
    }

    @Override
    public List<AddressDto> EntityList2DtoList(List<AddressEntity> daos) {
        if ( daos == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( daos.size() );
        for ( AddressEntity addressEntity : daos ) {
            list.add( Entity2Dto( addressEntity ) );
        }

        return list;
    }
}
