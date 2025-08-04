package com.store.car.service;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.mapper.CarPostMapper;
import com.store.car.mapper.OwnerPostMapper;
import com.store.car.repository.OwnerPostRepository;
import com.store.car.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

    private final OwnerPostMapper ownerPostMapper;
    private final OwnerPostRepository ownerPostRepository;


    public OwnerPostServiceImpl(OwnerPostMapper ownerPostMapper,
                                OwnerPostRepository ownerPostRepository) {
        this.ownerPostMapper = ownerPostMapper;
        this.ownerPostRepository = ownerPostRepository;
    }

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        // Validação dos campos da DTO
        Map<String, String> validationErrors = ValidationUtils.validateOwnerPostFields(ownerPostDTO);

        // Se houver erros de validação, retornar ou lançar uma exceção
        if (!validationErrors.isEmpty()) {
            // Exemplo: lançando uma exceção com os erros de validação
            throw new IllegalArgumentException("Erros de validação: " + validationErrors.toString());
        }

        // Mapear DTO para Entidade
        OwnerPostEntity ownerPost = ownerPostMapper.mapToEntity(ownerPostDTO);

        // Salvar no repositório
        ownerPostRepository.save(ownerPost);
    }

    @Override
    public List<OwnerPostDTO> getAllOwners() {
        List<OwnerPostEntity> entities = ownerPostRepository.findAll();
        return entities.stream()
                .map(ownerPostMapper::mapToDTO)
                .collect(Collectors.toList());
    }


}
