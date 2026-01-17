package com.educore.studentservice.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class StudentProducer {
    private final KafkaTemplate<String, StudentCreatedEvent> kafkaTemplate;
    public void sendStudentCreatedEvent(StudentCreatedEvent event) {
        Message<StudentCreatedEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "student-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
