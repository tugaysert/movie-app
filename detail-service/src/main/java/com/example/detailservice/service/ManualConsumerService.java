package com.example.detailservice.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ManualConsumerService {

    @Autowired
    private Consumer<String, Object> manualConsumer;
    private Logger logger = LoggerFactory.getLogger(ManualConsumerService.class);

    public List<Object> receiveMessages(String topicName, int partition, int offset) {

        TopicPartition topicPartition = new TopicPartition(topicName, partition);

        manualConsumer.assign(Arrays.asList(topicPartition)); //subscribe

        manualConsumer.seek(topicPartition, offset);

        ConsumerRecords<String, Object> records = manualConsumer.poll(Duration.ofMillis(1000));//Timeout 1sec

        for(ConsumerRecord<String, Object> record: records){
            logger.info("Record: {}", record);
        }

        manualConsumer.unsubscribe(); //close listener

        return StreamSupport.stream(records.spliterator(), false).map(ConsumerRecord::value).collect(Collectors.toList());

    }

}
