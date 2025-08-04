package com.portal.api.controller;


import com.portal.api.dto.CarPostDTO;
import com.portal.api.events.producer.EventProducerMessage;
import com.portal.api.service.api.CarPostStoreService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    private static final Logger LOG = LoggerFactory.getLogger(CarPostController.class);

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private EventProducerMessage eventProducerMessage;

    @PostMapping("/posts")
    public ResponseEntity<String> postCarSales(@RequestBody CarPostDTO carPostDTO) {
        LOG.info("USANDO EVENTO/MENSAGEM KAFKA - Informações do CarPost PRODUCER: {}", carPostDTO);

        // Envia a mensagem para o Kafka (evento)
        eventProducerMessage.sendMessage(carPostDTO);

        // Retorna 201 Created com a mensagem de sucesso
        return new ResponseEntity<>("Carro postado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        List<CarPostDTO> carSales = carPostStoreService.getCarForSale();

        // Retorna 200 OK com a lista de carros e mensagem
        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", "Lista de carros para venda recuperada com sucesso.")
                .body(carSales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        // Atualiza as informações do carro
        carPostStoreService.changeCarForSale(carPostDTO, id);

        // Retorna 200 OK com mensagem de sucesso
        return new ResponseEntity<>("Carro atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarForSale(@PathVariable("id") String id) {
        // Remove o carro à venda
        carPostStoreService.removeCarForSale(id);

        // Retorna 204 No Content com a mensagem
        return new ResponseEntity<>("Carro removido com sucesso!", HttpStatus.NO_CONTENT);
    }
}
