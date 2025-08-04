package com.portal.api.service.api;


import com.portal.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarForSale();

    void  changeCarForSale(CarPostDTO carPostDTO, String id);

    void removeCarForSale(String id);

}
