package com.wastemanager.address.controller;

import com.wastemanager.address.service.WasteManagerService;
import com.wastemanager.dto.WasteManagerDTO;
import com.wastemanager.exceptions.WasteManagerException;
import com.wastemanager.response.ResponseModel;
import com.wastemanager.util.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/manager")
public class WasteManagerController {

    private final WasteManagerService service;
    @Value("${manager.manager.kind}")
    private String kind;

    public WasteManagerController(WasteManagerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> create(@RequestBody WasteManagerDTO dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new WasteManagerException("Errors: \n" + Utils.buildErrorValidationMessage(bindingResult), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Created")
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .object(this.service.create(dto))
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> find(@PathVariable Long id){
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Created")
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .object(this.service.findById(id))
                        .build());
    }

    @PatchMapping
    public ResponseEntity<ResponseModel> update(@RequestBody WasteManagerDTO dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new WasteManagerException("Errors: \n" + Utils.buildErrorValidationMessage(bindingResult), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Updated")
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .object(this.service.update(dto))
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Deleted")
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .build());
    }

}
