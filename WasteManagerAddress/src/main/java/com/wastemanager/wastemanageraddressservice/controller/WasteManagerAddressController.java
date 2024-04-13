package com.wastemanager.wastemanageraddressservice.controller;

import com.wastemanager.wastemanageraddressservice.dto.WasteManagerAddressEntityDTO;
import com.wastemanager.wastemanageraddressservice.service.WasteManagerAddressService;
import com.wastemanager.wastemanageraddressservice.service.WasteManagerAddressServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wastemanager.model.WasteManagerAddressEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class WasteManagerAddressController {

    private final WasteManagerAddressService wasteManagerAddressService;

    public WasteManagerAddressController(WasteManagerAddressServiceImpl wasteManagerAddressService) {
        this.wasteManagerAddressService = wasteManagerAddressService;
    }

    @PostMapping
    public ResponseEntity<WasteManagerAddressEntity> create(@RequestBody WasteManagerAddressEntityDTO dto){
        return ResponseEntity.ok(wasteManagerAddressService.create(dto));
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody WasteManagerAddressEntity entity){
        wasteManagerAddressService.update(entity);
        return ResponseEntity.ok("Updated successfully");
    }

    @GetMapping
    public ResponseEntity<List<WasteManagerAddressEntity>> findAll(){
        return ResponseEntity.ok(wasteManagerAddressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteManagerAddressEntity> find(@PathVariable Long id){
        return ResponseEntity.ok(wasteManagerAddressService.find(id));
    }

    @GetMapping("/find")
    public ResponseEntity<List<WasteManagerAddressEntity>> find(@RequestParam Boolean enabled){
        return ResponseEntity.ok(wasteManagerAddressService.findByEnabledStatus(enabled));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        wasteManagerAddressService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

}
