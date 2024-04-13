package com.wastemanager.wastemanageraddressservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class WasteManagerAddressException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public WasteManagerAddressException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
