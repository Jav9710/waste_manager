package com.wastemanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WasteManagerDTO {
    private Long id;

    @Size(max = 12, message = "El nombre del WasteManager no puede tener más de 12 caracteres")
    private String nombre;

    @Pattern(regexp = "^nif-[A-Z]{1,}[0-9]{2,}-[0-9]{2}$", message = "Formato invalido para el identificador NIF")
    @Size(max = 10, message = "La dirección no puede tener más de 255 caracteres")
    private String nif;

    @JsonProperty("address_id")
    private Long addressId;
    @Pattern(regexp = "(true|false)", message = "El valor debe ser true o false")
    private Boolean isEnabled;

    private Long version;

}
