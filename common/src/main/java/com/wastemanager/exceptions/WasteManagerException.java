package com.wastemanager.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class WasteManagerException extends RuntimeException{

    private final String message;
    private final HttpStatus httpStatus;

    public WasteManagerException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
