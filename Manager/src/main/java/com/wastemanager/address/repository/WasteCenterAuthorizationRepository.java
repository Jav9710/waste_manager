package com.wastemanager.address.repository;


import com.wastemanager.model.WasteCenterAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCenterAuthorizationRepository extends JpaRepository<WasteCenterAuthorizationEntity, Long> {
}
