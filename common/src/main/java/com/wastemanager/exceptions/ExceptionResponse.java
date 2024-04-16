package com.wastemanager.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {

    private String message;
    @JsonProperty("status_code")
    private int statusCode;

    private String uuid;
    @JsonProperty("thorw_date")
    private Date throwDate;

}
