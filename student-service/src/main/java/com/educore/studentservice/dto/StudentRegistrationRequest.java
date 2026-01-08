package com.educore.studentservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record StudentRegistrationRequest(
        @NotNull(message = "First name is required")
        String firstName,

        String lastName,

        @NotNull(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotNull(message = "School ID is required")
        Integer schoolId
) {}
