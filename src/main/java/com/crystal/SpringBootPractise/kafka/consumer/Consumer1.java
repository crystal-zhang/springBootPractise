package com.crystal.SpringBootPractise.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer1 {
    @KafkaListener(topics = {"topic1"})
    public void listener(ConsumerRecord<String,Object> record){
        log.info("接收到消息:{}",record);

    }
}
