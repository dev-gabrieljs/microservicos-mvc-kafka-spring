package com.portal.api.service.impl;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.CarPostDTO;
import com.portal.api.service.api.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarForSale() {
        List<CarPostDTO> carPosts = carPostStoreClient.carForSaleClient();

        // Se não encontrar carros, retorna lista vazia
        if (carPosts == null || carPosts.isEmpty()) {
            return List.of();  // Retorna uma lista vazia
        }

        return carPosts;
    }

    @Override
    public void changeCarForSale(CarPostDTO carPostDTO, String id) {
        carPostStoreClient.chageCarForSaleClient(carPostDTO, id);
    }

    @Override
    public void removeCarForSale(String id) {
        // Chama o método para deletar o carro, sem verificar se o carro existe
        carPostStoreClient.deleteFDorSaleClient(id);
    }
}
