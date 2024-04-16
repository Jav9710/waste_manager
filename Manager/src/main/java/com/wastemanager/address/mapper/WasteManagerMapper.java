package com.wastemanager.address.mapper;

import com.wastemanager.address.config.WasterManagerAddressClient;
import com.wastemanager.address.service.CenterAuthorizationService;
import com.wastemanager.dto.WasteManagerDTO;
import com.wastemanager.model.WasteCenterAuthorizationEntity;
import com.wastemanager.model.WasteManagerAddressEntity;
import com.wastemanager.model.WasteManagerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class WasteManagerMapper {

    private final WasterManagerAddressClient addressClient;
    private final ModelMapper mapper;
    public WasteManagerMapper(WasterManagerAddressClient addressClient, ModelMapper mapper) {
        this.addressClient = addressClient;
        this.mapper = mapper;
    }

    public WasteManagerEntity toEntity(WasteManagerDTO dto){
        WasteManagerAddressEntity addressEntity = this.mapper.map(Objects.requireNonNull(addressClient.getWasteManagerAddressEntity(dto.getAddressId()).getBody()).getObject(), WasteManagerAddressEntity.class);
        WasteManagerEntity entity = new WasteManagerEntity();
        entity.setAddress(addressEntity);


        entity.setNif(dto.getNif());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
