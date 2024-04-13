package com.wastemanager.wastemanageraddressservice.mapper;

import com.wastemanager.wastemanageraddressservice.dto.WasteManagerAddressEntityDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.wastemanager.model.WasteManagerAddressEntity;

import java.util.Date;

@Component
public class WasteManagerAddressMapper {

    private final ModelMapper modelMapper;

    public WasteManagerAddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WasteManagerAddressEntity convertToEntity(WasteManagerAddressEntityDTO dto) {
        WasteManagerAddressEntity entity = modelMapper.map(dto, WasteManagerAddressEntity.class);
        Date date = new Date();
        entity.setCreatedDate(date);
        entity.setLastModifiedDate(date);

        return entity;
    }
}