package com.wasp.avt.employeeservice.model.dto;


public record APIResponseDto(
        EmployeeDto employee,
        DepartmentDto department,
        OrganizationDto organization) {
}
