package com.example.movieappbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class MockReviewService {

    private final Logger logger = LoggerFactory.getLogger(MockReviewService.class);

    @KafkaListener(topics = "review-transfer", groupId = "group-id")
    public void consume(String message) {
        logger.info(String.format("Message receiver \n %s", message));
    }


}
