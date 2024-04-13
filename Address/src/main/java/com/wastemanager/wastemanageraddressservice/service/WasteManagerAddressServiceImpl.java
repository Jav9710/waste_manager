package com.wastemanager.wastemanageraddressservice.service;

import com.wastemanager.wastemanageraddressservice.dto.WasteManagerAddressDTO;
import com.wastemanager.wastemanageraddressservice.exceptions.WasteManagerAddressException;
import com.wastemanager.wastemanageraddressservice.mapper.WasteManagerAddressMapper;
import com.wastemanager.wastemanageraddressservice.repository.WasteManagerAddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.wastemanager.model.WasteManagerAddressEntity;

import java.util.Date;
import java.util.List;

@Service
public class WasteManagerAddressServiceImpl implements WasteManagerAddressService{

    private final WasteManagerAddressMapper wasteManagerAddressMapper;
    private final WasteManagerAddressRepository wasteManagerAddressRepository;


    public WasteManagerAddressServiceImpl(WasteManagerAddressMapper wasteManagerAddressMapper, WasteManagerAddressRepository wasteManagerAddressRepository) {
        this.wasteManagerAddressMapper = wasteManagerAddressMapper;
        this.wasteManagerAddressRepository = wasteManagerAddressRepository;
    }

    public WasteManagerAddressDTO create(WasteManagerAddressDTO dto){
        WasteManagerAddressEntity entity = this.wasteManagerAddressMapper.convertToEntity(dto);
        return this.wasteManagerAddressMapper.convertToDTO(this.wasteManagerAddressRepository.save(entity));
    }

    public WasteManagerAddressDTO find(Long id){
        return this.wasteManagerAddressMapper.convertToDTO(
                this.wasteManagerAddressRepository.findById(id).orElseThrow(() -> new WasteManagerAddressException("No se encontró la dirección con ID: " + id, HttpStatus.NOT_FOUND)));
    }

    public List<WasteManagerAddressDTO> findAll(){
        List<WasteManagerAddressEntity> addresses = this.wasteManagerAddressRepository.findAll();
        if (addresses.isEmpty()) {
            throw new WasteManagerAddressException("No se encontraron direcciones.", HttpStatus.NOT_FOUND);
        }
        return addresses.stream().map(this.wasteManagerAddressMapper::convertToDTO).toList();
    }

    public void update(WasteManagerAddressEntity entity) {
        find(entity.getId());
        this.wasteManagerAddressRepository.save(entity);
    }

    public void delete(Long id){
        find(id);
        this.wasteManagerAddressRepository.deleteById(id);
    }

    public List<WasteManagerAddressEntity> findByEnabledStatus(Boolean enabled) {
        return this.wasteManagerAddressRepository.findByIsEnabled(enabled);
    }
//      By CreatedDate
    public List<WasteManagerAddressEntity> findByCreatedDateAfter(Date dateAfter) {
        return this.wasteManagerAddressRepository.findByCreatedDateAfter(dateAfter);
    }

    public List<WasteManagerAddressEntity> findByCreatedDateBefore(Date dateBefore) {
        return this.wasteManagerAddressRepository.findByCreatedDateBefore(dateBefore);
    }

    public List<WasteManagerAddressEntity> findByCreatedDateBetween(Date lowerBound, Date upperBound) {
        return this.wasteManagerAddressRepository.findByCreatedDateBetween(lowerBound, upperBound);
    }

//    By LastModifiedDate
    public List<WasteManagerAddressEntity> findByLastModifiedDateAfter(Date dateAfter) {
        return this.wasteManagerAddressRepository.findByLastModifiedDateAfter(dateAfter);
    }

    public List<WasteManagerAddressEntity> findByLastModifiedDateBefore(Date dateBefore) {
        return this.wasteManagerAddressRepository.findByLastModifiedDateBefore(dateBefore);
    }

    public List<WasteManagerAddressEntity> findByLastModifiedDateBetween(Date lowerBound, Date upperBound) {
        return this.wasteManagerAddressRepository.findByLastModifiedDateBetween(lowerBound, upperBound);
    }

}
