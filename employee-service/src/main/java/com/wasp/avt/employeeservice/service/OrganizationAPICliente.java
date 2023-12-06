package com.wasp.avt.employeeservice.service;

import com.wasp.avt.employeeservice.model.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationAPICliente {

    @GetMapping("v1/organizations/{id}")
    OrganizationDto getById(@PathVariable Long id);

    @GetMapping("v1/organizations/code/{code}")
    OrganizationDto getByCode(@PathVariable String code);
}
