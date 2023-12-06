package com.wasp.avt.employeeservice.service;


import com.wasp.avt.employeeservice.model.entity.Employee;
import com.wasp.avt.employeeservice.model.dto.APIResponseDto;
import com.wasp.avt.employeeservice.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    APIResponseDto getById(Long id);

    APIResponseDto getByEmail(String code);

    List<EmployeeDto> fetch();

    EmployeeDto create(Employee department);

    EmployeeDto update(Employee department);

    void delete(Long id);

}
