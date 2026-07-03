package com.projectmanagementapp.dto;

public record ProjectResponse(
    Long id,
    String code,
    String name,
    String status,
    String owner,
    String description
) {
}

