package com.wasp.avt.employeeservice.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record DepartmentDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        @Column(nullable = false)
        @NotEmpty(message = "The field 'name' cannot be empty")
        String name,
        String description,
        @Column(unique = true, nullable = false)
        @NotEmpty(message = "The field 'code' cannot be empty")
        String code) {
}
