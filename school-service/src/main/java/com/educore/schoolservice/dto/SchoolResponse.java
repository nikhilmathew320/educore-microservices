package com.educore.schoolservice.dto;

public record SchoolResponse(
        Integer schoolId,
        String schoolName,
        String email,
        String principalName
) {
}
