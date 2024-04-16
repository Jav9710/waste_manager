package com.wastemanager.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.UUID;

@ControllerAdvice
@Slf4j
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {WasteManagerException.class})
    protected ResponseEntity<ExceptionResponse> handleConflict(
            WasteManagerException ex,
            WebRequest request){

        return ResponseEntity.status(ex.getHttpStatus()).body(new ExceptionResponse(
                ex.getMessage(),
                ex.getHttpStatus().value(),
                UUID.randomUUID().toString(),
                new Date()
        ));
    }

}
