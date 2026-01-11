package com.educore.schoolservice.dto;

public record StudentResponse(
        Long studentId,
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}