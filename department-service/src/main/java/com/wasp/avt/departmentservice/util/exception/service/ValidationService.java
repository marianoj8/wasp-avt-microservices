package com.wasp.avt.departmentservice.util.exception.service;

import com.wasp.avt.departmentservice.repository.DepartmentRepository;
import com.wasp.avt.departmentservice.util.exception.BadRequestException;
import com.wasp.avt.departmentservice.util.exception.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ValidationService {
    private static final String ID_MESSAGE = "ID is missing";
    private static final String CODE_MESSAGE = "CODE is missing";

    public void throwNotFoundIfObjectDoesNotExists(Long id, DepartmentRepository repository, String message) {
        if (id == null) throw new BadRequestException(ID_MESSAGE);

        if (id <= 0 || repository.getDepartmentById(id) == null)
            throw new NotFoundException(message);
    }


    public void throwNotFoundIfObjectDoesNotExists(String code, DepartmentRepository repository, String message) {
        if (code == null) throw new BadRequestException(CODE_MESSAGE);

        if (repository.getDepartmentByCode(code) == null)
            throw new BadRequestException(message);
    }


}
