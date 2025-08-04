package com.portal.api.service.impl;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.OwnerPostDTO;
import com.portal.api.exeptions.custom.ValidationException;
import com.portal.api.service.api.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    private static final Logger LOG = LoggerFactory.getLogger(OwnerPostServiceImpl.class);

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        // Validação simples do DTO
        if (ownerPostDTO == null || ownerPostDTO.getName() == null || ownerPostDTO.getName().isEmpty()) {
            throw new ValidationException("O nome do proprietário não pode ser vazio.");
        }
        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}
