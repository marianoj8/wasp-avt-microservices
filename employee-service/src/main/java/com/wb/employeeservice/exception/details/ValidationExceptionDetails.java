package com.wb.employeeservice.exception.details;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {
    private final List<String> fields;
    private final List<String> fieldsMessage;
}
