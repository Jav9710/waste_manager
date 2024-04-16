package com.wastemanager.address.mapper;

import com.wastemanager.dto.CenterAuthorizationDTO;
import com.wastemanager.model.WasteCenterAuthorizationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WasteCenterAuthorizationMapper {

    private final ModelMapper mapper;

    public WasteCenterAuthorizationMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public WasteCenterAuthorizationEntity toEntity(CenterAuthorizationDTO newCenterAuthorizationDTO){
        return this.mapper.map(newCenterAuthorizationDTO, WasteCenterAuthorizationEntity.class);
    }

    public CenterAuthorizationDTO toDTO(WasteCenterAuthorizationEntity newCenterAuthorizationEntity){
        return this.mapper.map(newCenterAuthorizationEntity, CenterAuthorizationDTO.class);
    }

}
