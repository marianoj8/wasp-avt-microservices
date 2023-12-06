package com.wasp.avt.employeeservice.service;

import com.wasp.avt.employeeservice.model.dto.APIResponseDto;
import com.wasp.avt.employeeservice.model.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentAPIClient {

    @GetMapping("v1/departments/{id}")
    DepartmentDto getDepartment(@PathVariable Long id);

    @GetMapping("v1/departments/code/{code}")
    DepartmentDto getDepartment(@PathVariable String code);
}
