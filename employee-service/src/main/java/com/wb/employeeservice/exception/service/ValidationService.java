package com.wb.employeeservice.exception.service;

import com.wb.employeeservice.exception.BadRequestException;
import com.wb.employeeservice.exception.NotFoundException;
import com.wb.employeeservice.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ValidationService {
    private static final String ID_MESSAGE = "ID is missing";
    private static final String CODE_MESSAGE = "CODE is missing";

    public void throwNotFoundIfObjectDoesNotExists(Long id, EmployeeRepository repository, String message) {
        if (id == null) throw new BadRequestException(ID_MESSAGE);

        if (id <= 0 || repository.getReferenceById(id) == null)
            throw new NotFoundException(message);
    }

    public void throwNotFoundIfObjectDoesNotExists(String code, EmployeeRepository repository, String message) {
        if (code == null) throw new BadRequestException(CODE_MESSAGE);

        if (repository.getByEmail(code) == null)
            throw new BadRequestException(message);
    }

}
