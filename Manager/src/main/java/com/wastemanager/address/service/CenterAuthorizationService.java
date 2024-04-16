package com.wastemanager.address.service;

import com.wastemanager.dto.CenterAuthorizationDTO;
import com.wastemanager.exceptions.WasteManagerException;
import com.wastemanager.address.mapper.WasteCenterAuthorizationMapper;
import com.wastemanager.address.repository.WasteCenterAuthorizationRepository;
import com.wastemanager.model.WasteCenterAuthorizationEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CenterAuthorizationService {
    private final WasteCenterAuthorizationRepository centerAuthorizationRepository;
    private final WasteManagerService managerService;
    private final WasteCenterAuthorizationMapper centerAuthorizationMapper;
    public CenterAuthorizationService(WasteCenterAuthorizationRepository centerAuthorizationRepository, WasteManagerService managerService, WasteCenterAuthorizationMapper centerAuthorizationMapper) {
        this.centerAuthorizationRepository = centerAuthorizationRepository;
        this.managerService = managerService;
        this.centerAuthorizationMapper = centerAuthorizationMapper;
    }

    @Transactional
    public CenterAuthorizationDTO create(Long id, CenterAuthorizationDTO newCenterAuthorization) {
        WasteCenterAuthorizationEntity entity = this.centerAuthorizationMapper.toEntity(newCenterAuthorization);
        entity.setWasteManager(managerService.findById(id));

        return this.centerAuthorizationMapper.toDTO(this.centerAuthorizationRepository.save(entity));
    }

    @Transactional
    public CenterAuthorizationDTO update(Long id, CenterAuthorizationDTO updateCenterAuthorization) {
        WasteCenterAuthorizationEntity entity = findById(updateCenterAuthorization.getId());
        if(!id.equals(updateCenterAuthorization.getId())) entity.setWasteManager(managerService.findById(id));
        return this.centerAuthorizationMapper.toDTO(this.centerAuthorizationRepository.save(entity));
    }

    public WasteCenterAuthorizationEntity findById(Long id) {
       Optional<WasteCenterAuthorizationEntity> optionalEntity = this.centerAuthorizationRepository.findById(id);
       return optionalEntity
               .orElseThrow(() -> new WasteManagerException("No se encuentra un Centro de Authorizacion con el id " + id, HttpStatus.NOT_FOUND));
    }

    public List<WasteCenterAuthorizationEntity> findByIds(List<Long> ids) {
        List<WasteCenterAuthorizationEntity> entities = this.centerAuthorizationRepository.findAllById(ids);

        Set<Long> retrievedIds = entities.stream().map(WasteCenterAuthorizationEntity::getId).collect(Collectors.toSet());

        Set<Long> missingIds = ids.stream().filter(id -> !retrievedIds.contains(id)).collect(Collectors.toSet());

        if (!missingIds.isEmpty()) {
            throw new WasteManagerException("No se pudieron recuperar todas las entidades correspondientes a los IDs: " + missingIds, HttpStatus.NOT_FOUND);
        }
        if(entities.isEmpty()) throw  new WasteManagerException("No se encontraron Centros de Authorizacion con los id's " + ids, HttpStatus.NOT_FOUND);
        return entities;
    }

    public void delete(Long id) {
        findById(id);
        this.centerAuthorizationRepository.deleteById(id);
    }

    public List<CenterAuthorizationDTO> findAll() {
       return this.centerAuthorizationRepository.findAll().stream().map(this.centerAuthorizationMapper::toDTO).toList();
    }

}
