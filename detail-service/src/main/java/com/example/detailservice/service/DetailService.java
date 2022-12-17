package com.example.detailservice.service;

import com.example.detailservice.model.CreateDetail;
import com.example.detailservice.model.Detail;
import com.example.detailservice.repository.DetailRepository;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DetailService {

    private final Logger logger = LoggerFactory.getLogger(DetailService.class);
    private final DetailRepository detailRepository;


    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @KafkaListener(topics = "${kafka.first-topic}", containerFactory = "createDetailKafkaListenerContainerFactory")
    public void consume(@Payload CreateDetail message) {

        Detail detail = new Detail(null, message.getMovieId(), message.getText());
        detailRepository.save(detail);

        logger.info(detail.toString());
    }
/*
    @KafkaListener(topics = "${kafka.first-topic}",containerFactory = "createDetailKafkaListenerContainerFactory")
    public void listenFirstTopic (Object record){
        logger.info("Received message in group1 : {}", record);
    }*/
}
