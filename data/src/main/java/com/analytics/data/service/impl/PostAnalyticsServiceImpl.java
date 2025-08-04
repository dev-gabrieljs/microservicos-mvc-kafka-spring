package com.analytics.data.service.impl;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.entity.BrandAnalyticsEntity;
import com.analytics.data.entity.CarModelAnalyticsEntity;
import com.analytics.data.entity.CarModelPriceEntity;
import com.analytics.data.repository.BrandAnalyticsRepository;
import com.analytics.data.repository.CarModelAnalyticsRepository;
import com.analytics.data.repository.CarModelPriceRepository;
import com.analytics.data.service.api.PostAnalyticsService;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarModelPriceRepository carModelPriceRepository;

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {

        if (carPostDTO == null) {
            throw new ResourceNotFoundException("CarPost está nulo, não é possível processar os dados.");
        }

        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());
    }

    private void saveBrandAnalytics(String brand) {
        if (brand == null || brand.isEmpty()) {

            throw new ResourceNotFoundException("A marca é inválida.");
        }

        BrandAnalyticsEntity entity = new BrandAnalyticsEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item ->{
            item.setPosts(item.getPosts() + 1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            entity.setBrand(brand);
            entity.setPosts(1L);
            brandAnalyticsRepository.save(entity);
        });
    }

    private void saveCarModelAnalytics(String carModel) {
        if (carModel == null || carModel.isEmpty()) {
            throw new ResourceNotFoundException("O modelo do carro é inválido.");
        }

        CarModelAnalyticsEntity entity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(carModel).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            entity.setModel(carModel);
            entity.setPosts(1L);
            carModelAnalyticsRepository.save(entity);
        });
    }

    private void saveCarModelPriceAnalytics(String model, Double price) {
        if (model == null || model.isEmpty() || price == null || price <= 0) {
            throw new ResourceNotFoundException("O modelo do carro ou o preço são inválidos.");
        }

        CarModelPriceEntity entity = new CarModelPriceEntity();

        entity.setModel(model);
        entity.setPrice(price);

        carModelPriceRepository.save(entity);
    }
}
