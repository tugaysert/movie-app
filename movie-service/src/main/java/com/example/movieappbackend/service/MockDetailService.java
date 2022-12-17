package com.example.movieappbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class MockDetailService {

    private final Logger logger = LoggerFactory.getLogger(MockDetailService.class);
/*
    @KafkaListener(topics = "detail-transfer", groupId = "group-id")
    public void consume(String message) {
        logger.info(String.format("Message receiver \n %s", message));
    }*/


}
