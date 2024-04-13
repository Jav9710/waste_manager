package com.wastemanager.wastemanageraddressservice.service;

import com.wastemanager.wastemanageraddressservice.dto.WasteManagerAddressDTO;
import com.wastemanager.model.WasteManagerAddressEntity;

import java.util.Date;
import java.util.List;

public interface WasteManagerAddressService {

    WasteManagerAddressDTO create(WasteManagerAddressDTO dto);

    WasteManagerAddressDTO find(Long id);

    List<WasteManagerAddressDTO> findAll();

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
