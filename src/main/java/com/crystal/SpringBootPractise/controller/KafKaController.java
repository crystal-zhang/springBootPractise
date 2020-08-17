package com.crystal.SpringBootPractise.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * KafKa测试
 */
@RestController
@RequestMapping("/kafka")
public class KafKaController {
    @Autowired
    private KafkaTemplate  kafkaTemplate;
    @PostMapping("sendMsg")
    public String sendMsg(){
        kafkaTemplate.send("topic1","Kafka消息测试");
        return "success";
    }
}
