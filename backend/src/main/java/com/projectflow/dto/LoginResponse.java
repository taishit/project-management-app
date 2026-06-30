package com.projectflow.dto;

public record LoginResponse(
    String userName,
    String token,
    String message
) {
}
