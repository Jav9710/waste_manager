package com.wastemanager.wastemanageraddressservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WasteManagerAddressEntityDTO {

    private String direccion;
    private Boolean isEnabled;
}