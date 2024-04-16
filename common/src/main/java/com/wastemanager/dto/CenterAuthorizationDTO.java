package com.wastemanager.dto;

import com.wastemanager.model.WasteManagerEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CenterAuthorizationDTO {
    private Long id;

    @Size(max = 8, message = "El número de autorización no puede tener más de 8 caracteres")
    private String authorizationNumber;

}
