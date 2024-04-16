package com.wastemanager.address.service;

import com.wastemanager.dto.WasteManagerAddressDTO;
import com.wastemanager.exceptions.WasteManagerException;
import com.wastemanager.address.mapper.WasteManagerAddressMapper;
import com.wastemanager.address.repository.WasteManagerAddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.wastemanager.model.WasteManagerAddressEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class WasteManagerAddressService {

    private final WasteManagerAddressMapper wasteManagerAddressMapper;
    private final WasteManagerAddressRepository wasteManagerAddressRepository;


    public WasteManagerAddressService(WasteManagerAddressMapper wasteManagerAddressMapper, WasteManagerAddressRepository wasteManagerAddressRepository) {
        this.wasteManagerAddressMapper = wasteManagerAddressMapper;
        this.wasteManagerAddressRepository = wasteManagerAddressRepository;
    }
    @Transactional
    public WasteManagerAddressDTO create(WasteManagerAddressDTO dto){
        WasteManagerAddressEntity entity = this.wasteManagerAddressMapper.convertToEntity(dto);
        return this.wasteManagerAddressMapper.convertToDTO(this.wasteManagerAddressRepository.save(entity));
    }

    public WasteManagerAddressEntity findEntityById(Long id){
        return this.wasteManagerAddressRepository.findById(id).orElseThrow(() -> new WasteManagerException("No se encontró la dirección con ID: " + id, HttpStatus.NOT_FOUND));
    }
    public WasteManagerAddressDTO findById(Long id){
        return this.wasteManagerAddressMapper.convertToDTO(findEntityById(id));
    }

    public List<WasteManagerAddressDTO> findAll(){
        return this.wasteManagerAddressRepository.findAll().stream().map(this.wasteManagerAddressMapper::convertToDTO).toList();
    }

    @Transactional
    public void update(WasteManagerAddressDTO dto) {
        findById(dto.getId());
        this.wasteManagerAddressRepository.save(this.wasteManagerAddressMapper.convertToEntity(dto));
    }

    @Transactional
    public void delete(Long id){
        this.wasteManagerAddressRepository.deleteById(id);
    }

}
