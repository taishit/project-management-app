package com.projectmanagementapp.dto;

import java.time.LocalDateTime;

public record ProjectResponse(
    Long id,
    String projectKey,
    String name,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
