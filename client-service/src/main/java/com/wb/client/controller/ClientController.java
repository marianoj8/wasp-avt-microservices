package com.wb.client.controller;

import com.wb.client.services.ClientService;
import com.wb.core.models.dto.ClientDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/clientes")
@AllArgsConstructor
public class ClientController {

    private ClientService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
}
