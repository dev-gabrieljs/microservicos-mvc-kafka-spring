package com.store.car.message.consumer;


import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;


@Component
public class KafkaConsumerMessage {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listen(CarPostDTO carPostDTO) {
        logger.info("Mensagem recebida do Kafka: {}", carPostDTO);
        carPostService.newPostDetails(carPostDTO);
    }
}
