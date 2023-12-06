package com.wasp.avt.departmentservice.model.dto;

public record APIResponseDto(
        DepartmentDto department,
        OrganizationDto organization) {
}
