package com.portal.api.controller;

import com.portal.api.dto.OwnerPostDTO;
import com.portal.api.service.api.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    private static final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity<OwnerPostDTO> createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {

        LOG.info("USANDO API REST - Criando Novo Usuario Owner Post: {}", ownerPostDTO);

        // Chama o serviço para criar o novo dono de carro
        ownerPostService.createOwnerCar(ownerPostDTO);

        // Retorna um status 201 Created com o DTO criado no corpo
        return new ResponseEntity<>(ownerPostDTO, HttpStatus.CREATED);
    }
}
