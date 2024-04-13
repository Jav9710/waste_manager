package com.example.wastemanageraddressservice.service;

import com.example.wastemanageraddressservice.dto.WasteManagerAddressEntityDTO;
import org.wastemanager.model.WasteManagerAddressEntity;

import java.util.Date;
import java.util.List;

public interface WasteManagerAddressService {

    WasteManagerAddressEntity create(WasteManagerAddressEntityDTO dto);

    WasteManagerAddressEntity find(Long id);

    List<WasteManagerAddressEntity> findAll();

    void update(WasteManagerAddressEntity entity);

    void delete(Long id);

    List<WasteManagerAddressEntity> findByEnabledStatus(Boolean enabled);

    List<WasteManagerAddressEntity> findByCreatedDateAfter(Date dateAfter);

    List<WasteManagerAddressEntity> findByCreatedDateBefore(Date dateBefore);

    List<WasteManagerAddressEntity> findByCreatedDateBetween(Date lowerBound, Date upperBound);

    List<WasteManagerAddressEntity> findByLastModifiedDateAfter(Date dateAfter);

    List<WasteManagerAddressEntity> findByLastModifiedDateBefore(Date dateBefore);

    List<WasteManagerAddressEntity> findByLastModifiedDateBetween(Date lowerBound, Date upperBound);
}
