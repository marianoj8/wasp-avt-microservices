package com.wb.departmentservice.model.mapper;

import com.wb.departmentservice.model.entity.Department;
import com.wb.departmentservice.model.dto.DepartmentDto;


public class DepartmentMapper {
    public static DepartmentDto modelToDto(Department model) {
        return model == null ? null : new DepartmentDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getName(),
                model.getDescription(),
                model.getCode());
    }

    public static Department dtoToModel(DepartmentDto dto) {
        return dto == null ? null : new Department(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.name(),
                dto.description(),
                dto.code());
    }
}
