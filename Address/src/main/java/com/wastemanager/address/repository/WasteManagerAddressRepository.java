package com.wastemanager.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wastemanager.model.WasteManagerAddressEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface WasteManagerAddressRepository extends JpaRepository<WasteManagerAddressEntity, Long> {

    List<WasteManagerAddressEntity> findByIsEnabled(Boolean status);

    List<WasteManagerAddressEntity> findByCreatedDateAfter(Date date);
    List<WasteManagerAddressEntity> findByCreatedDateBefore(Date date);
    List<WasteManagerAddressEntity> findByCreatedDateBetween(Date lowerBound, Date upperBound);

    List<WasteManagerAddressEntity> findByLastModifiedDateAfter(Date date);
    List<WasteManagerAddressEntity> findByLastModifiedDateBefore(Date date);
    List<WasteManagerAddressEntity> findByLastModifiedDateBetween(Date lowerBound, Date upperBound);

}
