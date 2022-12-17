package com.example.reviewservice.service;

import com.example.reviewservice.model.CreateReview;
import com.example.reviewservice.model.Review;
import com.example.reviewservice.repository.ReviewRepository;
import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final Logger logger = LoggerFactory.getLogger(ReviewService.class);
    private final ReviewRepository reviewRepository;


    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @KafkaListener(topics = "${kafka.first-topic}", containerFactory = "createReviewKafkaListenerContainerFactory")
    public void consume(@Payload CreateReview message) {

        Review review = new Review(null, message.getMovieId(), message.getText());
        reviewRepository.save(review);

        logger.info(review.toString());
    }
/*
    @KafkaListener(topics = "${kafka.first-topic}",containerFactory = "createReviewKafkaListenerContainerFactory")
    public void listenFirstTopic (Object record){
        logger.info("Received message in group1 : {}", record);
    }*/
}
