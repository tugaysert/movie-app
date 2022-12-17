package com.example.reviewservice.config;

import com.example.reviewservice.model.CreateReview;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

@EnableKafka //required for @KafkaListener
@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String CONSUMER_BROKERS;

    @Bean
    public Consumer<String, Object> manualConsumer(){
        return consumerFactory("consumerGroupManual").createConsumer();
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> firstKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory("consumerGroup1"));
        factory.setConcurrency(3);
        factory.setAutoStartup(true);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CreateReview> createReviewKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, CreateReview> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryCreateReview("createReviewGroup"));
        factory.setAutoStartup(true);
        return factory;
    }

    private ConsumerFactory<String, Object> consumerFactory(String groupId) {

        Map<String, Object> props = new HashMap<>();

        props.put(BOOTSTRAP_SERVERS_CONFIG, CONSUMER_BROKERS);
        props.put(GROUP_ID_CONFIG, groupId);
        props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);
    }


    private ConsumerFactory<String, CreateReview> consumerFactoryCreateReview(String groupId) {

        Map<String, Object> props = new HashMap<>();

        props.put(BOOTSTRAP_SERVERS_CONFIG, CONSUMER_BROKERS);
        props.put(GROUP_ID_CONFIG, groupId);
        props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        JsonDeserializer<CreateReview> jsonDeserializer = new JsonDeserializer<>(CreateReview.class, false);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);
    }


}

