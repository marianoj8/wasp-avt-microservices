package com.wb.employeeservice.service;


import com.wb.employeeservice.model.entity.Employee;
import com.wb.employeeservice.model.dto.APIResponseDto;
import com.wb.employeeservice.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    APIResponseDto getById(Long id);

    APIResponseDto getByEmail(String code);

    List<EmployeeDto> fetch();

    EmployeeDto create(Employee department);

    EmployeeDto update(Employee department);

    void delete(Long id);

}
