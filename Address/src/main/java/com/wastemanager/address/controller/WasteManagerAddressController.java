package com.wastemanager.address.controller;


import com.wastemanager.dto.WasteManagerAddressDTO;
import com.wastemanager.address.service.WasteManagerAddressService;
import com.wastemanager.exceptions.WasteManagerException;
import com.wastemanager.response.ResponseModel;
import com.wastemanager.util.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api")
@Tag(name = "Waste Manager Address", description = "The Waste Manager Address API")
public class WasteManagerAddressController {

    private final WasteManagerAddressService wasteManagerAddressService;

    @Value("${address.kind}")
    private String kind;

    public WasteManagerAddressController(WasteManagerAddressService wasteManagerAddressService) {
        this.wasteManagerAddressService = wasteManagerAddressService;
    }

    @Operation(summary = "Persist a Waste Manager Address in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persisted entity in database", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseModel.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    @PostMapping
    public ResponseEntity<ResponseModel> create(
            @Parameter(description = "JSON for create a Waste Manager Entity")
            @RequestBody WasteManagerAddressDTO dto, BindingResult bindingResult){
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
                        .object(this.wasteManagerAddressService.create(dto))
                        .build());
    }

    @Operation(summary = "Update a Waste Manager Address in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseModel.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found", content = @Content) })
    @PatchMapping
    public ResponseEntity<ResponseModel> update(
            @Parameter(description = "JSON for update a Waste Manager Entity")
            @RequestBody WasteManagerAddressDTO dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new WasteManagerException("Errors: \n" + Utils.buildErrorValidationMessage(bindingResult), HttpStatus.BAD_REQUEST);
        }
        wasteManagerAddressService.update(dto);
        return ResponseEntity.ok(
                ResponseModel
                .builder()
                .message("Updated")
                .date(Instant.now())
                .uuid(UUID.randomUUID().toString())
                .kind(kind)
                .build());
    }

    @Operation(summary = "Find a Waste Manager Address in database by his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found a Waste Manager Addres", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseModel.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> find(
            @Parameter(description = "id for retrieve a Waste Manager Address entity from database")
            @PathVariable Long id){
        return ResponseEntity.ok(
                ResponseModel
                .builder()
                .message("Find entity with id " + id)
                .date(Instant.now())
                .uuid(UUID.randomUUID().toString())
                .kind(kind)
                .object(this.wasteManagerAddressService.findEntityById(id))
                .build());
    }


    @Operation(summary = "Find all Waste Managers Address in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Waste Managers Addres", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseModel.class))}),
            @ApiResponse(responseCode = "404", description = "Empty table", content = @Content) })
    @GetMapping
    public ResponseEntity<ResponseModel> findAll(){
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Find all entitys")
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .object(this.wasteManagerAddressService.findAll())
                        .build());
    }
    @Operation(summary = "Delete a Waste Managers Address in database by his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Waste Managers Addres", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseModel.class))}),
            @ApiResponse(responseCode = "404", description = "Empty table", content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> delete(
            @Parameter(description = "id for delete a Waste Manager Address entity in the database")
            @PathVariable Long id){
        this.wasteManagerAddressService.delete(id);
        return ResponseEntity.ok(
                ResponseModel
                        .builder()
                        .message("Deleted with id "+ id)
                        .date(Instant.now())
                        .uuid(UUID.randomUUID().toString())
                        .kind(kind)
                        .build());
    }

}
