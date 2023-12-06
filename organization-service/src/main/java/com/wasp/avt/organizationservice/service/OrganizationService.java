package com.wasp.avt.organizationservice.service;

import com.wasp.avt.organizationservice.model.entity.Organization;
import com.wasp.avt.organizationservice.model.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {
    OrganizationDto getOrganizationById(Long id);

    OrganizationDto getOrganizationByCode(String id);

    List<OrganizationDto> fetchOrganization(String name);

    OrganizationDto save(Organization model);

    OrganizationDto update(Organization model);

    void delete(Long id);

}
