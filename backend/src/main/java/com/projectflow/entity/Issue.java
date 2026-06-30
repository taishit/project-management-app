package com.projectflow.entity;

public record Issue(
    Long id,
    String issueKey,
    Long projectId,
    String projectName,
    String title,
    String status,
    String priority,
    String assignee,
    String dueDate,
    String description
) {
}
