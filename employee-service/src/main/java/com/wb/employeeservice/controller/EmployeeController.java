package com.wb.employeeservice.controller;

import com.wb.employeeservice.service.EmployeeService;
import com.wb.employeeservice.model.dto.APIResponseDto;
import com.wb.employeeservice.model.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wb.employeeservice.model.mapper.EmployeeMapper.dtoToModel;


@RestController
@RequestMapping("v1/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService service;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> fetch() {
        return new ResponseEntity<>(service.fetch(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(service.create(dtoToModel(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(service.update(dtoToModel(dto)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
