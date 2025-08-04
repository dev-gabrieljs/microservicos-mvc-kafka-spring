package com.portal.api.events.producer;


import com.portal.api.dto.CarPostDTO;
import com.portal.api.events.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventProducerMessage {
    @Autowired
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;


    public void sendMessage(CarPostDTO carPostDTO) {
        kafkaTemplate.send(Topic.KAFKA_TOPIC, carPostDTO);
    }
}
