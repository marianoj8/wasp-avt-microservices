package com.wasp.avt.departmentservice.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record OrganizationDto(
        Long id,
        @Column(columnDefinition = "timestamp default current_timestamp")
        LocalDateTime createdAt,
        @Column(columnDefinition = "timestamp")
        LocalDateTime lastModifiedAt,
        int totalModified,
        @NotEmpty(message = "The field 'name' cannot be empty")
        @Column(nullable = false, unique = true)
        String name,

        @NotEmpty(message = "The field 'nif' cannot be empty")
        @Column(nullable = false, unique = true)
        String nif,

        @Email(message = "The given 'email' is not valid")
        @NotEmpty(message = "The field 'email' cannot be empty")
        @Column(nullable = false, unique = true)
        String email,

        @NotEmpty(message = "The field 'code' cannot be empty")
        @Column(nullable = false, unique = true)
        String code) {
}
