package com.analytics.data.message.consumer;



import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.service.api.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerMessage {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PostAnalyticsService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listen(CarPostDTO carPostDTO) {
        logger.info("Mensagem recebida do Kafka: {}", carPostDTO);
        carPostService.saveDataAnalytics(carPostDTO);
    }
}
