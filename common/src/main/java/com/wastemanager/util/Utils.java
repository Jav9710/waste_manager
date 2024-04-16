package com.wastemanager.util;

import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@NoArgsConstructor
public class Utils {

    public static String buildErrorValidationMessage(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("Errors: \n");
        for (FieldError error : bindingResult.getFieldErrors()) {
            sb.append(String.format("- %s: %s\n", error.getField(), error.getDefaultMessage()));
        }
        return sb.toString();
    }
}
