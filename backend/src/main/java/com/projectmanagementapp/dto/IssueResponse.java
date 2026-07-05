package com.projectmanagementapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record IssueResponse(
    Long id,
    Long projectId,
    String projectKey,
    String projectName,
    String title,
    String description,
    String status,
    String statusLabel,
    String priority,
    String priorityLabel,
    String assigneeName,
    LocalDate dueDate,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
