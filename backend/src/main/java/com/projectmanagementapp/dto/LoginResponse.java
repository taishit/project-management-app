package com.projectmanagementapp.dto;

public record LoginResponse(
    String userName,
    String token,
    String message
) {
}

