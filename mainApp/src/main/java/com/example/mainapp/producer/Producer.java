package com.example.mainapp.producer;

import com.example.mainapp.exception.InternalServerErrorException;
import com.example.mainapp.user.UserStatDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    @Value("${topic.name}")
    private String userTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserStatDto userStatDto) {
        try {
            String userStatAsMessage = objectMapper.writeValueAsString(userStatDto);
            kafkaTemplate.send(userTopic, userStatAsMessage);
            log.info("Статистика пользователя={} отправлена в топик={}", userStatAsMessage, userTopic);
        } catch (JsonProcessingException e) {
            throw new InternalServerErrorException(e);
        }
    }
}
