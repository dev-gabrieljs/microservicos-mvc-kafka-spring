package com.store.car.mapper;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import org.springframework.stereotype.Component;

@Component
public class OwnerPostMapper {
    public OwnerPostEntity mapToEntity(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPostDTO.getType());
        ownerPost.setContactNumber(ownerPostDTO.getContactNumber());
        return ownerPost;
    }

    public OwnerPostDTO mapToDTO(OwnerPostEntity entity) {
        OwnerPostDTO dto = new OwnerPostDTO();
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setContactNumber(entity.getContactNumber());
        return dto;
    }
}
