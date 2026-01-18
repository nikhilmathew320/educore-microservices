package com.educore.schoolservice.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SchoolConsumer {

    @KafkaListener(topics = "student-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeStudentCreatedEvent(StudentCreatedEvent event){
        log.info("Received Student Created Event in School Service: {}", event);
    }
}
