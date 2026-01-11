package com.educore.schoolservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SchoolRegistrationRequest(
        @NotBlank(message = "School name is required")
        String schoolName,

        @NotBlank(message = "Email is required")
        @Email(message = "invalid email format")
        String email,

        String principalName
) {
}
