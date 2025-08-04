package com.store.car.mapper;


import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.entity.OwnerPostEntity;
import org.springframework.stereotype.Component;

@Component
public class CarPostMapper {

    public CarPostDTO toDTO(CarPostEntity entity) {
        return CarPostDTO.builder()
                .model(entity.getModel())
                .brand(entity.getBrand())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .engineVersion(entity.getEngine())
                .city(entity.getCity())
                .createdDate(entity.getCreated())
                .contact(entity.getContact())
                .ownerId(entity.getOwnerPost().getId())
                .ownerName(entity.getOwnerPost().getName())
                .build();
    }

    public CarPostEntity toEntity(CarPostDTO dto) {
        CarPostEntity entity = new CarPostEntity();
        entity.setModel(dto.getModel());
        entity.setBrand(dto.getBrand());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setEngine(dto.getEngineVersion());
        entity.setCity(dto.getCity());
        entity.setCreated(dto.getCreatedDate());
        entity.setContact(dto.getContact());
        return entity;
    }



}

