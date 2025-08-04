package com.portal.api.service.api;


import com.portal.api.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerCar(OwnerPostDTO ownerPostDTO);


}
