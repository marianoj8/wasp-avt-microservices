package com.wb.organizationservice.controller;

import com.wb.organizationservice.model.dto.OrganizationDto;
import com.wb.organizationservice.service.impl.OrganizationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wb.organizationservice.model.mapper.OrganizationMapper.dtoToModel;
import static org.springframework.http.HttpStatus.*;

@Tag(
        name = "Organization-Controller",
        description = "Organization Controller Exposes REST APIs for Organization Service"
)
@RestController
@AllArgsConstructor
@RequestMapping("v1/organizations")
public class OrganizationController {
    private OrganizationServiceImpl service;

    @GetMapping("{id}")
    @Operation(
            summary = "GET Organization By Id",
            description = "Get Organization By Id REST APIs is used to get a single Organization from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "If 'Organization' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<OrganizationDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getOrganizationById(id), OK);
    }

    @GetMapping("code/{code}")
    @Operation(
            summary = "GET Organization By Code",
            description = "Get Organization By Code REST APIs is used to get a single Organization from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "If 'Organization' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<OrganizationDto> getByCode(@PathVariable String code) {
        return new ResponseEntity<>(service.getOrganizationByCode(code), OK);
    }

    @GetMapping
    @Operation(
            summary = "Get a list of 'Organization' filtering by name",
            description = "Get Organization REST APIs is used to return a list of Organizations from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<List<OrganizationDto>> fetch(
            @RequestParam(value = "name", defaultValue = "") String name) {
        return new ResponseEntity<>(service.fetchOrganization(name), OK);
    }

    @PostMapping
    @Operation(
            summary = "Create 'Organization' in the Database",
            description = "POST Organization REST APIs is used to create a new 'Organization' into database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<OrganizationDto> create(@RequestBody @Valid OrganizationDto dto) {
        return new ResponseEntity<>(service.save(dtoToModel(dto)), CREATED);
    }

    @PutMapping
    @Operation(
            summary = "Update 'Organization' in the Database",
            description = "PUT Organization REST APIs is used to modify a 'Organization' in the database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "ACCEPTED - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND - If 'Organization' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<OrganizationDto> modify(@RequestBody @Valid OrganizationDto dto) {
        return new ResponseEntity<>(service.update(dtoToModel(dto)), ACCEPTED);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete 'Organization' in the Database",
            description = "DELETE Organization REST APIs is used to delete a 'Organization' from database"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "NO_CONTENT - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND - If 'Organization' does not exists in the Database.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
