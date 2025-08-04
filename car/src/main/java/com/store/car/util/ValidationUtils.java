package com.store.car.util;

import com.store.car.dto.CarPostDTO;
import com.store.car.dto.OwnerPostDTO;

import java.util.Map;
import java.util.HashMap;


public class ValidationUtils {

    // Função que valida todos os campos da DTO e retorna um mapa de erros
    public static Map<String, String> validateCarPostFields(CarPostDTO carPostDTO) {
        // Mapa para armazenar os erros de validação
        Map<String, String> errors = new HashMap<>();

        // Verificando cada campo diretamente
        if (carPostDTO.getDescription() == null || carPostDTO.getDescription().trim().isEmpty()) {
            errors.put("Description", "Description é inválido.");
        }

        if (carPostDTO.getBrand() == null || carPostDTO.getBrand().trim().isEmpty()) {
            errors.put("Brand", "Brand é inválido.");
        }

        if (carPostDTO.getModel() == null || carPostDTO.getModel().trim().isEmpty()) {
            errors.put("Model", "Model é inválido.");
        }

        if (carPostDTO.getPrice() == null || carPostDTO.getPrice() <= 0) {
            errors.put("Price", "Price é inválido.");
        }

        if (carPostDTO.getEngineVersion() == null || carPostDTO.getEngineVersion().trim().isEmpty()) {
            errors.put("Engine", "Engine é inválido.");
        }

        if (carPostDTO.getCity() == null || carPostDTO.getCity().trim().isEmpty()) {
            errors.put("City", "City é inválido.");
        }

        if (carPostDTO.getContact() == null || carPostDTO.getContact().trim().isEmpty()) {
            errors.put("Contact", "Contact é inválido.");
        }

        // Retorna o mapa de erros (vazio se não houver erros)
        return errors;
    }

    public static Map<String, String> validateOwnerPostFields(OwnerPostDTO ownerPostDTO) {
        // Mapa para armazenar os erros de validação
        Map<String, String> errors = new HashMap<>();

        // Verificando cada campo
        if (ownerPostDTO.getName() == null || ownerPostDTO.getName().isBlank()) {
            errors.put("name", "O nome do proprietário não pode ser vazio.");
        }

        if (ownerPostDTO.getType() == null || ownerPostDTO.getType().isBlank()) {
            errors.put("type", "O tipo do proprietário não pode ser vazio.");
        }

        if (ownerPostDTO.getContactNumber() == null || ownerPostDTO.getContactNumber().isBlank()) {
            errors.put("contactNumber", "O número de contato não pode ser vazio.");
        }

        // Retorna o mapa de erros (vazio se não houver erros)
        return errors;
    }
}
