package com.wb.organizationservice.model.mapper;

import com.wb.organizationservice.model.entity.Organization;
import com.wb.organizationservice.model.dto.OrganizationDto;

public class OrganizationMapper {
    public static OrganizationDto modelToDto(Organization model) {
        return model == null ? null : new OrganizationDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getName(),
                model.getDescription(),
                model.getNif(),
                model.getEmail(),
                model.getCode());
    }

    public static Organization dtoToModel(OrganizationDto dto) {
        return dto == null ? null : new Organization(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.name(),
                dto.description(),
                dto.nif(),
                dto.email(),
                dto.code());
    }
}
