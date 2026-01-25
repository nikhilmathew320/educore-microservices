package com.educore.identityservice.dto;

public record AuthRequest(
        String username,
        String password
) {
}
