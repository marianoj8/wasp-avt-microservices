package com.wb.core.models.mapper;

import com.wb.core.models.dto.ClientDTO;
import com.wb.core.models.entity.ClientEntity;

public class ClientMapper {

    public static ClientDTO modelToDto(ClientEntity entity) {
        return new ClientDTO(entity.getId());
    }

    public static ClientEntity dtoToModel(ClientDTO dto) {
        if (dto == null) return null;
        var model = new ClientEntity();

        model.setId(dto.id());

        return model;
    }
}
