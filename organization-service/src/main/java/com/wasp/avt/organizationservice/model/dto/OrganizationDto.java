package com.wasp.avt.organizationservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Schema(
        description = "OrganizationDto model information"
)
public record OrganizationDto(
        @Schema(
                description = "The ID for Department is required only for Method such as PUT and DELETE",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        Long id,
        @Schema(
                description = "The value of this field is automatically generated by the API. (Optional)",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        LocalDateTime createdAt,
        @Schema(
                description = "The value of this field is automatically generated by the API. (Optional)",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        LocalDateTime lastModifiedAt,
        @Schema(
                description = "The value of this field is automatically generated by the API. (Optional)",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        int totalModified,
        @Schema(
                description = "The name for Organization is required",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotEmpty(message = "The field 'name' cannot be empty")
        @Column(nullable = false, unique = true)
        String name,
        @Schema(
                description = "The description for Organization is optional",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        String description,

        @Schema(
                description = "The nif for Organization is required",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotEmpty(message = "The field 'nif' cannot be empty")
        @Column(nullable = false, unique = true)
        String nif,
        @Schema(
                description = "The email for Organization is required. It must be unique and valid",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @Email(message = "The given 'email' is not valid")
        @NotEmpty(message = "The field 'email' cannot be empty")
        @Column(nullable = false, unique = true)
        String email,
        @Schema(
                description = "The code for Organization is required. It must be unique",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotEmpty(message = "The field 'code' cannot be empty")
        @Column(nullable = false, unique = true)
        String code) {
}
