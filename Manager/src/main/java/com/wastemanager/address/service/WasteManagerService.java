package com.wastemanager.address.service;

import com.wastemanager.address.mapper.WasteManagerMapper;

import com.wastemanager.address.repository.WasteManagerRepository;
import com.wastemanager.dto.WasteManagerDTO;
import com.wastemanager.exceptions.WasteManagerException;
import com.wastemanager.model.WasteManagerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WasteManagerService {

    private final WasteManagerRepository wasteManagerRepository;
    private final WasteManagerMapper wasteManagerMapper;

    public WasteManagerService(WasteManagerRepository wasteManagerRepository, WasteManagerMapper wasteManagerMapper) {
        this.wasteManagerRepository = wasteManagerRepository;
        this.wasteManagerMapper = wasteManagerMapper;
    }

    public WasteManagerEntity create(WasteManagerDTO dto){
        return this.wasteManagerRepository.save(this.wasteManagerMapper.toEntity(dto));

    }

    public WasteManagerEntity findById(Long id){
        Optional<WasteManagerEntity> entity = this.wasteManagerRepository.findById(id);
        if(entity.isPresent()) return entity.get();
        else throw new WasteManagerException("No se encuentra ningun WasteManager con id: " + id, HttpStatus.NOT_FOUND);
    }

    public WasteManagerEntity update(WasteManagerDTO dto){
        WasteManagerEntity entity = findById(dto.getId());
        if(!dto.getAddressId().equals(entity.getAddress().getId())) {
            WasteManagerEntity dtoEntity = this.wasteManagerMapper.toEntity(dto);
            entity.setAddress(dtoEntity.getAddress());

        }
        entity.setNombre(dto.getNombre());
        entity.setEnabled(dto.getIsEnabled());
        return this.wasteManagerRepository.save(entity);
    }

    public void delete(Long id){
        findById(id);
        this.wasteManagerRepository.deleteById(id);
    }

}
