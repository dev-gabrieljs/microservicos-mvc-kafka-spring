package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerPostService {

    void createOwnerPost (OwnerPostDTO ownerPostDTO);
    List<OwnerPostDTO> getAllOwners();
}
