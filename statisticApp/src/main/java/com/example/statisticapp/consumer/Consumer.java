package com.example.statisticapp.consumer;

import com.example.statisticapp.user.UserStatDto;
import com.example.statisticapp.user.UserStatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    private static final String USER_TOPIC = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final UserStatService userStatService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, UserStatService userStatService) {
        this.objectMapper = objectMapper;
        this.userStatService = userStatService;
    }

    @KafkaListener(topics = USER_TOPIC)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("Сообщение={} принято в топике {}", message, USER_TOPIC);
        UserStatDto userStatDto = objectMapper.readValue(message, UserStatDto.class);
        userStatService.createUserStat(userStatDto);
    }
}
