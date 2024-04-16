package com.wastemanager.address.controller;

import com.wastemanager.address.request.ListIds;
import com.wastemanager.dto.CenterAuthorizationDTO;
import com.wastemanager.address.service.CenterAuthorizationService;
import com.wastemanager.exceptions.WasteManagerException;
import com.wastemanager.response.ResponseModel;
import com.wastemanager.util.Utils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/authorization")
@Tag(name = "Waste Center Authorization Manager", description = "The Waste Center Authorization Manager API")
public class CenterAuthorizationController {

    private final CenterAuthorizationService authorizationService;
    @Value("${manager.center.kind}")
    private String kind;

    public CenterAuthorizationController(CenterAuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
    @PostMapping("/manager/{id}")
    public ResponseEntity<ResponseModel> create(@PathVariable Long id,@RequestBody CenterAuthorizationDTO dto, BindingResult bindingResult){
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
                        .object(this.authorizationService.create(id, dto))
                        .build());
    }

    @PatchMapping("/manager/{id}")
    public ResponseEntity<ResponseModel> update(@PathVariable Long id, @RequestBody CenterAuthorizationDTO dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new WasteManagerException("Errors: \n" + Utils.buildErrorValidationMessage(bindingResult), HttpStatus.BAD_REQUEST);
        }
        this.authorizationService.update(id, dto);
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Updated entity with id " + dto.getId())
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .build());
    }
    @GetMapping
    public ResponseEntity<ResponseModel> findAll(){
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Find all entitys")
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .object(this.authorizationService.findAll())
                        .build());
    }

    @PostMapping("/find/ids")
    public ResponseEntity<ResponseModel> findAllByIds(@RequestBody ListIds listIds, BindingResult bindingResult){
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Find all entitys")
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .object(this.authorizationService.findByIds(listIds.getIds()))
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> findById(@PathVariable Long id){
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Find entity with id" + id)
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .object(this.authorizationService.findById(id))
                        .build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteById(@PathVariable Long id){
        this.authorizationService.delete(id);
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Deleted entity with id" + id)
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .build());
    }


}
