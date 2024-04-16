package com.wastemanager.address.repository;

import com.wastemanager.model.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerRepository extends JpaRepository<WasteManagerEntity, Long> {
}
