package com.wasp.avt.employeeservice.model.mapper;


import com.wasp.avt.employeeservice.model.dto.EmployeeDto;
import com.wasp.avt.employeeservice.model.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto modelToDto(Employee model) {
        return model == null ? null : new EmployeeDto(model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getFirstName(),
                model.getLastName(),
                model.getGender(),
                model.getEmail(),
                model.getDepartmentId(),
                model.getOrganizationId());
    }

    public static Employee dtoToModel(EmployeeDto dto) {
        return dto == null ? null : new Employee(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.firstName(),
                dto.lastName(),
                dto.gender(),
                dto.email(),
                dto.departmentId(),
                dto.organizationId());
    }
}
