package com.wb.departmentservice.controller;

import com.wb.departmentservice.model.dto.DepartmentDto;
import com.wb.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wb.departmentservice.model.mapper.DepartmentMapper.dtoToModel;

@Tag(
        name = "Department-Controller",
        description = "Department Controller Exposes REST APIs for Department Service"
)
@RestController
@RequestMapping("v1/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService service;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "GET Department By Id",
            description = "Get Department By Id REST APIs is used to get a single Department from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "If 'Department' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<DepartmentDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("code/{code}")
    @Operation(
            summary = "GET Department By Code",
            description = "Get Department By Code REST APIs is used to get a single Department from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "If 'Department' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<DepartmentDto> getByCode(@PathVariable String code) {
        return new ResponseEntity<>(service.getByCode(code), HttpStatus.OK);
    }

    @GetMapping
    @Operation(
            summary = "Get a list of 'Department' filtering by name",
            description = "Get Department REST APIs is used to return a list of Departments from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<List<DepartmentDto>> fetch() {
        return new ResponseEntity<>(service.fetch(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(
            summary = "Create 'Department' in the Database",
            description = "POST Department REST APIs is used to create a new 'Department' into database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<DepartmentDto> create(@RequestBody @Valid DepartmentDto dto) {
        return new ResponseEntity<>(service.create(dtoToModel(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(
            summary = "Update 'Department' in the Database",
            description = "PUT Department REST APIs is used to modify a 'Department' in the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "ACCEPTED - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND - If 'Department' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<DepartmentDto> update(@RequestBody @Valid DepartmentDto dto) {
        return new ResponseEntity<>(service.update(dtoToModel(dto)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete 'Department' in the Database",
            description = "DELETE Department REST APIs is used to delete a 'Department' from database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "NO_CONTENT - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND - If 'Department' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
