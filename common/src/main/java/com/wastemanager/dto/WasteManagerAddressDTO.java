package com.wastemanager.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WasteManagerAddressDTO {
    private Long id;

    @Size(max = 255, message = "La dirección no puede tener más de 255 caracteres")
    private String direccion;
    @Pattern(regexp = "(true|false)", message = "El valor de isEnabled debe ser true o false")
    private Boolean isEnabled;
    private Long version;
}