package com.wb.employeeservice.service.impl;

import com.wb.employeeservice.exception.service.ValidationService;
import com.wb.employeeservice.model.dto.APIResponseDto;
import com.wb.employeeservice.model.dto.DepartmentDto;
import com.wb.employeeservice.model.dto.EmployeeDto;
import com.wb.employeeservice.model.dto.OrganizationDto;
import com.wb.employeeservice.model.entity.Employee;
import com.wb.employeeservice.model.mapper.EmployeeMapper;
import com.wb.employeeservice.repository.EmployeeRepository;
import com.wb.employeeservice.service.DepartmentAPIClient;
import com.wb.employeeservice.service.EmployeeService;
import com.wb.employeeservice.service.OrganizationAPICliente;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static com.wb.employeeservice.model.mapper.EmployeeMapper.modelToDto;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;
    // private RestTemplate restTemplate;
    // private WebClient webClient;
    private DepartmentAPIClient departmentAPIClient;
    private OrganizationAPICliente organizationAPICliente;
    private ValidationService validationService;


//        @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getById(Long id) {
        validationService.throwNotFoundIfObjectDoesNotExists(id, repository, String.format("Employee with ID: %d Doesn't exists", id));

        var employee = modelToDto(repository.getReferenceById(id));


        // TODO: Communication using RestTemplate

        // ResponseEntity<DepartmentDto> resp = restTemplate.getForEntity(
        // "http://localhost:8080/v1/department/" + employee.getDepartmentCode(),
        // DepartmentDto.class);
        // DepartmentDto departmentDto = resp.getBody();

        // TODO: Communication using WebClient

//         DepartmentDto departmentDto =
//         webClient.get().uri("http://localhost:8080/v1/department/" +
//         employee.getDepartmentId())
//         .retrieve()
//         .bodyToMono(DepartmentDto.class)
//         .block();

        // TODO: Communication using OpenFeign/APIClient
        var departmentDto = departmentAPIClient.getDepartment(employee.departmentId());
        var organizationDto = organizationAPICliente.getById(employee.organizationId());

        return new APIResponseDto(employee, departmentDto, organizationDto);
    }

    private EmployeeDto getEmployeeById(Long id) {
        validationService.throwNotFoundIfObjectDoesNotExists(id, repository, String.format("Employee with ID: %d Doesn't exists", id));
        return modelToDto(repository.getReferenceById(id));
    }

    @Override
    public APIResponseDto getByEmail(String email) {
        validationService.throwNotFoundIfObjectDoesNotExists(email, repository, String.format("Employee with Email: %s Doesn't exists", email));
        var employee = modelToDto(repository.getByEmail(email));
        var departmentDto = departmentAPIClient.getDepartment(employee.departmentId());
        var organizationDto = organizationAPICliente.getById(employee.organizationId());

        return new APIResponseDto(employee, departmentDto, organizationDto);
    }

    @Override
    public List<EmployeeDto> fetch() {
        return repository.findAll()
                .stream()
                .map(EmployeeMapper::modelToDto).toList();
    }

    @Override
    public EmployeeDto create(Employee model) {
        model.setCreatedAt(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        return modelToDto(repository.save(model));
    }

    @Override
    public EmployeeDto update(Employee model) {
        var dto = getEmployeeById(model.getId());

        model.setCreatedAt(dto.createdAt());
        model.setLastModifiedAt(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
        model.setTotalModified(dto.totalModified() + 1);

        return modelToDto(repository.save(model));
    }

    @Override
    public void delete(Long id) {
        validationService.throwNotFoundIfObjectDoesNotExists(id, repository, String.format("Employee with ID: %d Doesn't exists", id));
        repository.deleteById(id);
    }
//    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultOrganization")
    public APIResponseDto getDefaultDepartment(Long id, Exception ex) {
        var employeeDto = modelToDto(repository.getReferenceById(id));
        var departmentDto = new DepartmentDto(
                null,
                ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime(),
                null,
                0,
                "Department",
                "Department Service Unavailable",
                "0000"
        );

        var organizationDto = organizationAPICliente.getById(employeeDto.organizationId());

        return new APIResponseDto(employeeDto, departmentDto, organizationDto);
    }

    public APIResponseDto getDefaultOrganization(Long id, Exception ex) {
        validationService.throwNotFoundIfObjectDoesNotExists(id, repository, String.format("Department with ID: %d Doesn't exists", id));

        var employeeDto = modelToDto(repository.getReferenceById(id));
        var departmentDto = departmentAPIClient.getDepartment(employeeDto.departmentId());

        var organizationDto = new OrganizationDto(
                null,
                ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime(),
                null,
                0,
                "Organization Service Unavailable",
                "00000000000",
                "email-exaple@example.com",
                "code example");

        return new APIResponseDto(employeeDto, departmentDto, organizationDto);
    }

//    public APIResponseDto getDefaultOrganization(String code, Exception ex) {
//        validationService.throwNotFoundIfObjectDoesNotExists(code, repository, String.format("Department with Code: %s Doesn't exists", code));
//
//        var departmentDto = modelToDto(repository.getDepartmentByCode(code));
//        var organizationDto = new OrganizationDto(
//                null,
//                ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime(),
//                null,
//                0,
//                "Organization Service Unavailable",
//                "00000000000",
//                "email-exaple@example.com",
//                "code example");
//
//        return new APIResponseDto(departmentDto, organizationDto);
//    }
}
