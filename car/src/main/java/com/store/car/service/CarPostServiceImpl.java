package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.mapper.CarPostMapper;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import com.store.car.util.ValidationUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Autowired
    private CarPostMapper carPostMapper;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        // Validando os campos
        Map<String, String> validationErrors = ValidationUtils.validateCarPostFields(carPostDTO);

        // Se houver erros de validação, retorna um erro adequado
        if (!validationErrors.isEmpty()) {
            // Lançando uma exceção com todos os erros de validação
            throw new IllegalArgumentException("Campos inválidos: " + String.join(", ", validationErrors.values()));
        }

        // Continua o processamento se não houver erros de validação
        ownerPostRepository.findById(carPostDTO.getOwnerId())
                .ifPresentOrElse(owner -> {
                    CarPostEntity carPostEntity = carPostMapper.toEntity(carPostDTO);
                    carPostEntity.setOwnerPost(owner);
                    carPostEntity.setContact(owner.getContactNumber());
                    carPostRepository.save(carPostEntity);
                }, () -> {
                    throw new EntityNotFoundException("Owner com ID " + carPostDTO.getOwnerId() + " não encontrado.");
                });
    }


    @Override
    public List<CarPostDTO> getCarSales() {
        return carPostRepository.findAll()
                .stream()
                .map(carPostMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarPostDTO changeCarSale(CarPostDTO carPostDTO, Long postId) {
        // Validando os campos
        Map<String, String> validationErrors = ValidationUtils.validateCarPostFields(carPostDTO);

        // Se houver erros de validação, retorne um erro adequado
        if (!validationErrors.isEmpty()) {
            // Exemplo de como tratar erros: poderia lançar um erro customizado ou retornar uma resposta com erros.
            throw new IllegalArgumentException("Campos inválidos: " + validationErrors.toString());
        }

        CarPostEntity updatedEntity = carPostRepository.findById(postId)
                .map(carPost -> {
                    carPost.setDescription(carPostDTO.getDescription());
                    carPost.setBrand(carPostDTO.getBrand());
                    carPost.setModel(carPostDTO.getModel());
                    carPost.setPrice(carPostDTO.getPrice());
                    carPost.setEngine(carPostDTO.getEngineVersion());
                    carPost.setCity(carPostDTO.getCity());
                    carPost.setContact(carPostDTO.getContact());

                    return carPostRepository.save(carPost);
                })
                .orElseThrow(() -> new EntityNotFoundException("Postagem com ID " + postId + " não encontrada"));

        return carPostMapper.toDTO(updatedEntity);
    }

    @Override
    public void removeCarSale(Long postId) {
        if (!carPostRepository.existsById(postId)) {
            throw new EntityNotFoundException("Postagem com ID " + postId + " não encontrada.");
        }

        carPostRepository.deleteById(postId);
    }
}
