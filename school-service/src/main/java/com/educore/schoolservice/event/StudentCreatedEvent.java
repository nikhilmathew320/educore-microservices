package com.educore.schoolservice.event;

public record StudentCreatedEvent(
        Long id,
        String firstname,
        String lastname,
        String email
) {
}
