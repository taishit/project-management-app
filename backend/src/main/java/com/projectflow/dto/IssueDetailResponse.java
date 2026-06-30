package com.projectflow.dto;

public record IssueDetailResponse(
    Long id,
    String issueKey,
    String projectName,
    String title,
    String status,
    String priority,
    String assignee,
    String dueDate,
    String description
) {
}
