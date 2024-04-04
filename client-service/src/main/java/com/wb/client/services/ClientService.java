package com.wb.client.services;

import com.wb.core.models.dto.ClientDTO;
import com.wb.core.models.mapper.ClientMapper;
import com.wb.core.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository repository;

    public ClientDTO getById(Long id) {
        return ClientMapper.modelToDto(repository.findOne(id));
    }
}
