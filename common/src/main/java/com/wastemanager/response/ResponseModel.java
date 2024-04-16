package com.wastemanager.response;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseModel {

    private String message;
    private String uuid;
    private Instant date;
    private Object object;
    private String kind;

}
