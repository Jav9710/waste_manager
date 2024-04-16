package com.wastemanager.address.mapper;

import com.wastemanager.dto.WasteManagerAddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.wastemanager.model.WasteManagerAddressEntity;

@Component
public class WasteManagerAddressMapper {

    private final ModelMapper modelMapper;

    public WasteManagerAddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WasteManagerAddressEntity convertToEntity(WasteManagerAddressDTO dto) {
        return modelMapper.map(dto, WasteManagerAddressEntity.class);
    }

    public WasteManagerAddressDTO convertToDTO(WasteManagerAddressEntity entity) {
        return modelMapper.map(entity, WasteManagerAddressDTO.class);
    }

}