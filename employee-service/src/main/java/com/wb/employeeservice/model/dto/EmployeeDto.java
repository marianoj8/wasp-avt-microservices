package com.wb.employeeservice.model.dto;

import com.wb.employeeservice.model.entity.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EmployeeDto(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt,
        int totalModified,
        @NotEmpty(message = "The field 'firstName' cannot be empty")
        String firstName,
        @NotEmpty(message = "The field 'lastName' cannot be empty")
        String lastName,
        Gender gender,
        @Column(nullable = false, unique = true)
        @NotEmpty(message = "The field 'email' cannot be empty")
        @Email(message = "Given email is not valid")
        String email,
        @NotNull(message = "The field 'departmentId' cannot be null")
        @Column(nullable = false)
        Long departmentId,

        @NotNull(message = "The field 'organizationId' cannot be null")
        @Column(nullable = false)
        Long organizationId) {

}
