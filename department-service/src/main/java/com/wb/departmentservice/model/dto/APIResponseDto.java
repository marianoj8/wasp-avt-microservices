package com.wb.departmentservice.model.dto;

public record APIResponseDto(
        DepartmentDto department,
        OrganizationDto organization) {
}
