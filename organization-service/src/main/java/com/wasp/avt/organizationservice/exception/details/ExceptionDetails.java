package com.wasp.avt.organizationservice.exception.details;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    protected String title;
    protected int status;
    protected String details;
    protected String path;
    protected String developerMessage;
    protected LocalDateTime timestamp;

}
