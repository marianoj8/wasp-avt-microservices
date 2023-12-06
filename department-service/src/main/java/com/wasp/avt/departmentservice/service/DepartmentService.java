package com.wasp.avt.departmentservice.service;


import com.wasp.avt.departmentservice.model.entity.Department;
import com.wasp.avt.departmentservice.model.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto getById(Long id);
    DepartmentDto getByCode(String code);
    List<DepartmentDto> fetch();
    DepartmentDto create(Department department);
    DepartmentDto update(Department department);
    void delete(Long id);

}
