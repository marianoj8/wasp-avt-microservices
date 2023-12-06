package com.wasp.avt.departmentservice.service.impl;


import com.wasp.avt.departmentservice.model.entity.Department;
import com.wasp.avt.departmentservice.repository.DepartmentRepository;
import com.wasp.avt.departmentservice.service.DepartmentService;
import com.wasp.avt.departmentservice.model.dto.DepartmentDto;
import com.wasp.avt.departmentservice.util.exception.service.ValidationService;
import com.wasp.avt.departmentservice.model.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static com.wasp.avt.departmentservice.model.mapper.DepartmentMapper.modelToDto;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository repository;
    private ValidationService validationService;

    @Override
    public DepartmentDto getById(Long id) {
        validationService.throwNotFoundIfObjectDoesNotExists(id, repository, String.format("Department with ID: %s Doesn't exists", id));
        return modelToDto(repository.getReferenceById(id));
    }

    @Override
    public DepartmentDto getByCode(String code) {
        validationService.throwNotFoundIfObjectDoesNotExists(code, repository, String.format("Department with Code: %s Doesn't exists", code));
      return modelToDto(repository.getDepartmentByCode(code));
    }

    @Override
    public List<DepartmentDto> fetch() {
        return repository.findAll().stream().map(DepartmentMapper::modelToDto).toList();
    }

    @Override
    public DepartmentDto create(Department model) {
        model.setCreatedAt(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        return modelToDto(repository.save(model));
    }

    @Override
    public DepartmentDto update(Department model) {

        DepartmentDto dto = getById(model.getId());

        model.setCreatedAt(dto.createdAt());
        model.setLastModifiedAt(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        model.setTotalModified(dto.totalModified() + 1);

        return modelToDto(repository.save(model));
    }

    @Override
    public void delete(Long id) {
        validationService.throwNotFoundIfObjectDoesNotExists(id, repository, String.format("Department with ID: %s Doesn't exists", id));
        repository.deleteById(id);
    }
}
