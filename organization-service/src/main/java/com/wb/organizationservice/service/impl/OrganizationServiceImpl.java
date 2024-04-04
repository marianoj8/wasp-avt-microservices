package com.wb.organizationservice.service.impl;

import com.wb.organizationservice.model.entity.Organization;
import com.wb.organizationservice.exception.service.ValidationService;
import com.wb.organizationservice.model.dto.OrganizationDto;
import com.wb.organizationservice.model.mapper.OrganizationMapper;
import com.wb.organizationservice.repository.OrganizationRepository;
import com.wb.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static com.wb.organizationservice.model.mapper.OrganizationMapper.dtoToModel;
import static com.wb.organizationservice.model.mapper.OrganizationMapper.modelToDto;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository repository;
    private ValidationService validateService;

    @Override
    public OrganizationDto getOrganizationById(Long id) {
        validateService.throwNotFoundIfObjectDoesNotExists(id, repository,
                String.format("Organization with Id: %d not found", id));
        return modelToDto(repository.getReferenceById(id));
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        validateService.throwNotFoundIfObjectDoesNotExists(code, repository,
                String.format("Organization with Code: %s not found", code));
        return modelToDto(repository.getOrganizationByCode(code));
    }

    @Override
    public List<OrganizationDto> fetchOrganization(String name) {
        return repository.fetch(name)
                .stream()
                .map(OrganizationMapper::modelToDto).toList();
    }

    @Override
    public OrganizationDto save(Organization model) {
        model.setCreatedAt(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        return modelToDto(repository.save(model));
    }

    @Override
    public OrganizationDto update(Organization model) {
        var m = getOrganizationById(model.getId());
        model.setCreatedAt(m.createdAt());
        model.setCreatedAt(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        model.setTotalModified(m.totalModified() + 1);
        return modelToDto(repository.save(model));
    }

    @Override
    public void delete(Long id) {
        repository.delete(dtoToModel(getOrganizationById(id)));
    }
}
