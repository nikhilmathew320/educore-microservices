package com.educore.schoolservice.dto;

import java.util.List;

public record SchoolResponse(
        Integer schoolId,
        String schoolName,
        String email,
        String principalName,
        List<StudentResponse> students
) {
}
