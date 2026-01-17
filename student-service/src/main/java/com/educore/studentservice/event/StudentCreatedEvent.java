package com.educore.studentservice.event;

public record StudentCreatedEvent(
        Long studentId,
        String firstName,
        String secondName,
        String email
) {
}
